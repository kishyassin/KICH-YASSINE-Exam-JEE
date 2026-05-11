import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InsuranceService } from '../services/insurance';
import { Payment } from '../models/insurance.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.html',
  styleUrls: ['./payments.css'],
  standalone: false
})
export class Payments implements OnInit {
  contractId!: number;
  payments: Array<Payment> = [];
  paymentFormGroup!: FormGroup;
  errorMessage!: string;

  constructor(
    private route: ActivatedRoute,
    private insuranceService: InsuranceService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.contractId = this.route.snapshot.params['contractId'];
    this.handleGetPayments();
    
    this.paymentFormGroup = this.fb.group({
      amount: this.fb.control('', [Validators.required, Validators.min(1)]),
      type: this.fb.control('MENSUALITE', [Validators.required]),
      date: this.fb.control(new Date().toISOString().substring(0, 10), [Validators.required])
    });
  }

  handleGetPayments() {
    this.insuranceService.getPayments(this.contractId).subscribe({
      next: (data) => {
        this.payments = data;
      },
      error: (err) => {
        this.errorMessage = err.message;
      }
    });
  }

  handleSavePayment() {
    let payment = this.paymentFormGroup.value;
    this.insuranceService.savePayment(payment, this.contractId).subscribe({
      next: (data) => {
        alert("Payment saved successfully!");
        this.handleGetPayments();
        this.paymentFormGroup.reset({
          amount: '',
          type: 'MENSUALITE',
          date: new Date().toISOString().substring(0, 10)
        });
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
