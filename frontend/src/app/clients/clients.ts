import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { InsuranceService } from '../services/insurance';
import { Client } from '../models/insurance.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.html',
  styleUrls: ['./clients.css'],
  standalone: false
})
export class Clients implements OnInit {
  clients: Array<Client> = [];
  filteredClients: Array<Client> = [];
  searchKeyword: string = "";
  errorMessage!: string;

  constructor(
    private insuranceService: InsuranceService, 
    private router: Router,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.handleGetClients();
  }

  handleGetClients() {
    this.insuranceService.getClients().subscribe({
      next: (data) => {
        this.clients = data;
        this.handleSearch();
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = err.message;
      }
    });
  }

  handleSearch() {
    this.filteredClients = this.clients.filter(c => 
      (c.nom && c.nom.toLowerCase().includes(this.searchKeyword.toLowerCase())) ||
      (c.email && c.email.toLowerCase().includes(this.searchKeyword.toLowerCase()))
    );
  }

  handleViewContracts(client: Client) {
    this.router.navigateByUrl("/contracts", { state: client });
  }
}
