import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../services/insurance';
import { InsuranceContract } from '../models/insurance.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.html',
  styleUrls: ['./contracts.css'],
  standalone: false
})
export class Contracts implements OnInit {
  contracts: Array<InsuranceContract> = [];
  errorMessage!: string;

  constructor(private insuranceService: InsuranceService, private router: Router) { }

  ngOnInit(): void {
    this.handleGetContracts();
  }

  handleGetContracts() {
    this.insuranceService.getContracts().subscribe({
      next: (data) => {
        this.contracts = data;
      },
      error: (err) => {
        this.errorMessage = err.message;
      }
    });
  }

  handleViewPayments(contract: InsuranceContract) {
    this.router.navigateByUrl(`/payments/${contract.id}`);
  }
}
