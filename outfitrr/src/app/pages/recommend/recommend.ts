import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { RecommendationResult } from '../../models/recommendation-result';
import { Recommendation } from '../../services/recommendation';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Feedback } from '../../services/feedback';
import { SavedOutfit } from '../../services/saved-outfit';
import { Router, RouterLink } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-recommend',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './recommend.html',
  styleUrl: './recommend.css',
})
export class Recommend implements OnInit {
  @ViewChild('imageCanvas', { static: false })
  canvas!: ElementRef<HTMLCanvasElement>;

  ctx!: CanvasRenderingContext2D;
  image = new Image();

  hexColor = '#000000';
  occasion = 'CASUAL';
  skinTone = 'MEDIUM';

  showMenu = false;

  isLoading = false;
  loadingMessage = '';

  results: RecommendationResult[] = [];

  constructor(
    private recommendationService: Recommendation,
    private feedbackService: Feedback,
    private savedOutfitService: SavedOutfit,
    private router: Router,
    private authService:Auth
  ) {}

  userName = '';

ngOnInit(){
  const user = this.authService.getUser();
  this.userName = user.name;
}
  getRecommendations() {
    this.isLoading = true;
    this.loadingMessage = 'Analyzing shirt color...';

    setTimeout(() => {
      this.loadingMessage = 'Finding matching pant colors...';
    }, 1000);

    const request = {
      hexColor: this.hexColor,
      occasion: this.occasion,
      skinTone: this.skinTone,
    };

    this.recommendationService.getRecommendations(request).subscribe((data) => {
      this.results = data;
      this.isLoading = false;
    });
  }

  onImageUpload(event: any) {
    const file = event.target.files[0];

    if (!file) return;

    const reader = new FileReader();

    reader.onload = () => {
      this.image.src = reader.result as string;

      this.image.onload = () => {
        const canvas = this.canvas.nativeElement;

        canvas.width = this.image.width;
        canvas.height = this.image.height;

        this.ctx = canvas.getContext('2d')!;
        this.ctx.drawImage(this.image, 0, 0);
      };
    };

    reader.readAsDataURL(file);
  }

  pickColor(event: MouseEvent) {
    const canvas = this.canvas.nativeElement;

    const rect = canvas.getBoundingClientRect();

    const scaleX = canvas.width / rect.width;
    const scaleY = canvas.height / rect.height;

    const x = (event.clientX - rect.left) * scaleX;
    const y = (event.clientY - rect.top) * scaleY;

    const pixel = this.ctx.getImageData(x, y, 1, 1).data;

    const r = pixel[0];
    const g = pixel[1];
    const b = pixel[2];

    console.log('RGB:', r, g, b);

    this.hexColor = this.rgbToHex(r, g, b);
  }

  getColorCategory(hex: string): string {
    const r = parseInt(hex.substring(1, 3), 16);
    const g = parseInt(hex.substring(3, 5), 16);
    const b = parseInt(hex.substring(5, 7), 16);

    if (r > 200 && g > 200 && b > 200) return 'PASTEL';

    if (r > g && r > b) return 'WARM';

    if (b > r && b > g) return 'COOL';

    if (r < 80 && g < 80 && b < 80) return 'DARK';

    if (r > 120 && g > 80 && b < 80) return 'EARTH';

    return 'NEUTRAL';
  }

  rgbToHex(r: number, g: number, b: number): string {
    return '#' + [r, g, b].map((x) => x.toString(16).padStart(2, '0')).join('');
  }

  sendFeedback(color: string, liked: boolean) {
    const request = {
      baseColorCategory: this.getColorCategory(this.hexColor),
      recommendedColor: color,
      occasion: this.occasion,
      skinTone: this.skinTone,
      liked: liked,
    };

    this.feedbackService.submitFeedback(request).subscribe(() => {
      console.log('Feedback submitted');
    });
  }

  saveOutfit(color: string) {
    const request = {
      shirtColorHex: this.hexColor,
      pantColor: color,
      occasion: this.occasion,
      skinTone: this.skinTone,
    };

    this.savedOutfitService.saveOutfit(request).subscribe(() => {
      alert('Outfit saved!');
    });
  }

  toggleMenu() {
    this.showMenu = !this.showMenu;
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  pantColorMap: any = {
    NEUTRAL: [
      { name: 'Grey', hex: '#808080' },
      { name: 'Beige', hex: '#F5F5DC' },
    ],

    DARK: [
      { name: 'Black', hex: '#000000' },
      { name: 'Navy', hex: '#000080' },
    ],

    EARTH: [
      { name: 'Brown', hex: '#8B4513' },
      { name: 'Olive', hex: '#556B2F' },
    ],

    COOL: [
      { name: 'Blue', hex: '#1E90FF' },
      { name: 'Teal', hex: '#008080' },
    ],

    WARM: [
      { name: 'Maroon', hex: '#800000' },
      { name: 'Rust', hex: '#B7410E' },
    ],

    PASTEL: [
      { name: 'Mint', hex: '#98FF98' },
      { name: 'Light Blue', hex: '#ADD8E6' },
    ],
  };
}
