import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceService } from '../services/insurance';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.html',
  standalone: false
})
export class NewClient implements OnInit {
  newClientFormGroup!: FormGroup;

  constructor(private fb: FormBuilder, private insuranceService: InsuranceService, private router: Router) { }

  ngOnInit(): void {
    this.newClientFormGroup = this.fb.group({
      nom: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required, Validators.email])
    });
  }

  handleSaveClient() {
    let client = this.newClientFormGroup.value;
    this.insuranceService.saveClient(client).subscribe({
      next: (data) => {
        alert("Client has been successfully saved!");
        this.router.navigateByUrl("/clients");
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
