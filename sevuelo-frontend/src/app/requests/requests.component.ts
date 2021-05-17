import { Component, OnInit } from '@angular/core';
import { Request } from '../request.model';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  requests: Request[];
  selectedRequest: Request;

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.getRequests();
  }
  
  onSelect(request: Request): void {
    this.selectedRequest = request;
  }

  getRequests(): void {
    this.requestService.getRequests()
      .subscribe(requests => this.requests = requests);
  }

}
