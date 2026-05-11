export interface Client {
  id: number;
  nom: string;
  email: string;
}

export interface InsuranceContract {
  id: number;
  subscriptionDate: Date;
  status: string;
  validationDate: Date;
  contributionAmount: number;
  duration: number;
  coverageRate: number;
  type: string;
  // Subclass specific fields
  registrationNumber?: string;
  brand?: string;
  model?: string;
  housingType?: string;
  address?: string;
  area?: number;
  coverageLevel?: string;
  personsCovered?: number;
}

export interface Payment {
  id: number;
  date: Date;
  amount: number;
  type: string;
}
