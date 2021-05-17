import { Component, Input, OnInit } from '@angular/core';
import { Request } from '../request.model';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-request-detail',
  templateUrl: './request-detail.component.html',
  styleUrls: ['./request-detail.component.scss']
})
export class RequestDetailComponent implements OnInit {

  @Input() request: Request;

  constructor(
    private requestService: RequestService
  ) { }

  ngOnInit(): void {
  }

  previousState(): void {
    window.history.back();
  }

  reserve(): void {
    console.log("Test");
    this.requestService.reserveRequest(this.request)
      .subscribe((newRequest) => {
        this.request = newRequest
        this.previousState();
      }
    );

  }

}
