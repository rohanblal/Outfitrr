import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedOutfits } from './saved-outfits';

describe('SavedOutfits', () => {
  let component: SavedOutfits;
  let fixture: ComponentFixture<SavedOutfits>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SavedOutfits]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavedOutfits);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
