export interface IRequest {
  id?: number;
  passenger?: string;
  destination?: string;
  status?: string;
}

export const defaultValue: IRequest = {};
