import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client, InsuranceContract, Payment } from '../models/insurance.model';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {
  private backendHost = "http://localhost:8081/api";

  constructor(private http: HttpClient) { }

  public getClients(): Observable<Array<Client>> {
    return this.http.get<Array<Client>>(`${this.backendHost}/clients`);
  }

  public saveClient(client: Client): Observable<Client> {
    return this.http.post<Client>(`${this.backendHost}/clients`, client);
  }

  public getContracts(): Observable<Array<InsuranceContract>> {
    return this.http.get<Array<InsuranceContract>>(`${this.backendHost}/contracts`);
  }

  public getClientContracts(clientId: number): Observable<Array<InsuranceContract>> {
    return this.http.get<Array<InsuranceContract>>(`${this.backendHost}/contracts/client/${clientId}`);
  }

  public getPayments(contractId: number): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(`${this.backendHost}/contracts/${contractId}/payments`);
  }

  public savePayment(payment: any, contractId: number): Observable<Payment> {
    return this.http.post<Payment>(`${this.backendHost}/contracts/${contractId}/payments`, payment);
  }
}
