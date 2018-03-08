
drop database Shipping
go
create database Shipping
go
use Shipping
go
CREATE TABLE Setor (	CodSetor INTEGER IDENTITY PRIMARY KEY,
						NomeSetor VARCHAR(50) NOT NULL);


CREATE TABLE Funcionario (	Matricula INTEGER IDENTITY(100000,1) PRIMARY KEY,
							NomeFuncionario VARCHAR(30) NOT NULL,
							senha VARCHAR (10),
							CodSetor INTEGER REFERENCES Setor (CodSetor) NOT NULL);

CREATE TABLE Protocolo (	idEnvio INTEGER PRIMARY KEY IDENTITY (100000,1),
							data DATE NOT NULL,
							Hora TIME(0) NOT NULL,
							titulo VARCHAR(50) NOT NULL,
							link VARCHAR(500) NOT NULL,
							matriculaEmi INTEGER REFERENCES Funcionario (Matricula) NOT NULL,
							matriculaDes INTEGER REFERENCES Funcionario (Matricula) NOT NULL,
							CHECK (matriculaDes <> matriculaEmi));

CREATE TABLE LeituraProtocolo (	idAcesso INTEGER PRIMARY KEY IDENTITY(100,1),
                       			dataLeitura DATE NOT NULL,
								HoraLeitura TIME NOT NULL,
								referenciaProtocolo VARCHAR(22)NOT NULL,
								idEnvio INTEGER REFERENCES Protocolo (idEnvio)NOT NULL);
