import { TestBed } from '@angular/core/testing';

import { SavedOutfit } from './saved-outfit';

describe('SavedOutfit', () => {
  let service: SavedOutfit;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SavedOutfit);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
