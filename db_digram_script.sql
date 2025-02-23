

CREATE TABLE branch (
  idBranch uuid NOT NULL PRIMARY KEY,
  name text,
  address text,
  phoneNumber text,
  prefix text
);


CREATE TABLE pawn (
  idPawn uuid NOT NULL PRIMARY KEY,
  pawnTicketId text NOT NULL,
  principal decimal,
  startDate date,
  endDate date,
  isOriginal boolean NOT NULL
);


CREATE TABLE employeeDetails (
  idEmployeeDetails uuid NOT NULL PRIMARY KEY,
  idEmployee uuid,
  baseSalary decimal,
  allowances decimal,
  addBenefits decimal,
  joinDate timestamp
);


CREATE TABLE item (
  idItem uuid NOT NULL PRIMARY KEY,
  name text NOT NULL,
  type text NOT NULL,
  weight decimal NOT NULL,
  purity text,
  description text,
  pawnPrice decimal NOT NULL,
  status text,
  idBranch uuid NOT NULL,
  imageSrc text,
  sellingPrice decimal,
  soldDate date
);


CREATE TABLE computation (
  idComputation uuid NOT NULL PRIMARY KEY,
  interestRate decimal,
  vat decimal,
  penaltyRate decimal,
  advInterestRate decimal,
  addFees decimal,
  createdOn decimal
);


CREATE TABLE redemption (
  idRedemption uuid NOT NULL PRIMARY KEY,
  originalPawn uuid NOT NULL,
  newPawn uuid,
  redemptionDate timestamp NOT NULL,
  payment decimal NOT NULL,
  interest decimal NOT NULL,
  penalty decimal NOT NULL
);


CREATE TABLE renewal (
  idRenewal uuid NOT NULL PRIMARY KEY,
  originalPawn uuid,
  newPawn uuid,
  renewalDate timestamp,
  payment decimal,
  interest decimal,
  penalty decimal
);


CREATE TABLE goldRate (
  idGoldRate uuid NOT NULL PRIMARY KEY,
  goldPerOunceDollar decimal,
  dollarRate decimal,
  goldPerGramPeso decimal NOT NULL,
  createdOn timestamp NOT NULL
);


CREATE TABLE transaction (
  idTransaction uuid NOT NULL PRIMARY KEY,
  type text,
  netAmount decimal,
  idBranch uuid,
  idPawn uuid,
  idRenewal uuid,
  idRedemption uuid,
  idCustomer uuid,
  idClerk uuid,
  idBranchManager uuid,
  comments text,
  createdOn timestamp
);


CREATE TABLE customerDetails (
  idCustomerDetails uuid NOT NULL PRIMARY KEY,
  idCustomer uuid,
  address text,
  phoneNumber text,
  imageIdSrc text
);


CREATE TABLE appUser (
  idAppUser uuid NOT NULL PRIMARY KEY,
  firstName text NOT NULL,
  middleName text,
  lastName text NOT NULL,
  birthDate date NOT NULL,
  email text,
  password text,
  sex text NOT NULL,
  type text NOT NULL,
  createdOn timestamp NOT NULL,
  isActive boolean NOT NULL
);


CREATE TABLE itemPawnConn (
  idItemPawnConn uuid NOT NULL PRIMARY KEY,
  idPawn uuid NOT NULL,
  idItem uuid NOT NULL
);


ALTER TABLE customerDetails ADD CONSTRAINT customerDetails_idCustomer_fk FOREIGN KEY (idCustomer) REFERENCES appUser (idAppUser);
ALTER TABLE employeeDetails ADD CONSTRAINT employeeDetails_idEmployee_fk FOREIGN KEY (idEmployee) REFERENCES appUser (idAppUser);
ALTER TABLE itemPawnConn ADD CONSTRAINT itemPawnConn_idItem_fk FOREIGN KEY (idItem) REFERENCES item (idItem);
ALTER TABLE itemPawnConn ADD CONSTRAINT itemPawnConn_idPawn_fk FOREIGN KEY (idPawn) REFERENCES pawn (idPawn);
ALTER TABLE redemption ADD CONSTRAINT redemption_idPawn_fk FOREIGN KEY (originalPawn) REFERENCES pawn (idPawn);
ALTER TABLE redemption ADD CONSTRAINT redemption_newPawn_fk FOREIGN KEY (newPawn) REFERENCES pawn (idPawn);
ALTER TABLE renewal ADD CONSTRAINT renewal_newPawn_fk FOREIGN KEY (newPawn) REFERENCES pawn (idPawn);
ALTER TABLE renewal ADD CONSTRAINT renewal_originalPawn_fk FOREIGN KEY (originalPawn) REFERENCES pawn (idPawn);
ALTER TABLE transaction ADD CONSTRAINT transaction_idBranch_fk FOREIGN KEY (idBranch) REFERENCES branch (idBranch);
ALTER TABLE transaction ADD CONSTRAINT transaction_idBranchManager_fk FOREIGN KEY (idBranchManager) REFERENCES appUser (idAppUser);
ALTER TABLE transaction ADD CONSTRAINT transaction_idClerk_fk FOREIGN KEY (idClerk) REFERENCES appUser (idAppUser);
ALTER TABLE transaction ADD CONSTRAINT transaction_idCustomer_fk FOREIGN KEY (idCustomer) REFERENCES appUser (idAppUser);
ALTER TABLE transaction ADD CONSTRAINT transaction_idPawn_fk FOREIGN KEY (idPawn) REFERENCES pawn (idPawn);
ALTER TABLE transaction ADD CONSTRAINT transaction_idRedemption_fk FOREIGN KEY (idRedemption) REFERENCES redemption (idRedemption);
ALTER TABLE transaction ADD CONSTRAINT transaction_idRenewal_fk FOREIGN KEY (idRenewal) REFERENCES renewal (idRenewal);
