import { UserType } from "../user-create/user-type.enum";

export class User {
  id: number;
  name: string;
  lastName: string;
  email: string;
  userName: string;
  password: string;
  type: UserType;
}

