import { TestBed } from '@angular/core/testing';

import { CommentaryServiceService } from './commentary-service.service';

describe('CommentaryServiceService', () => {
  let service: CommentaryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommentaryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
