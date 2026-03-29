import { Component, OnInit } from '@angular/core';
import { SavedOutfit } from '../../services/saved-outfit';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-saved-outfits',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './saved-outfits.html',
  styleUrl: './saved-outfits.css',
})
export class SavedOutfits implements OnInit {

  outfits:any[] = [];

  constructor(private savedOutfitService: SavedOutfit, private http: HttpClient){}

  ngOnInit(){

    this.savedOutfitService.getSavedOutfits().subscribe({
      next:(data)=>{
        this.outfits = data;
      },
      error:()=>{
        console.log("Failed to fetch outfits");
      }
    })

  }
  goBack(){
  window.history.back();
}
deleteOutfit(id:number){

  this.savedOutfitService.deleteOutfit(id).subscribe(()=>{
    this.outfits = this.outfits.filter(o => o.id !== id);
  });

}
}