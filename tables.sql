CREATE TABLE 'bac' (
	'notaBac' VARCHAR(255) NOT NULL,
	'tipExamen' VARCHAR(255) NOT NULL
);

CREATE TABLE 'candidati' (
	'nume' VARCHAR(255) NOT NULL,
	'varsta' VARCHAR(255) NOT NULL,
	'medieBac' VARCHAR(255) NOT NULL,
	'notaExamen' VARCHAR(255) NOT NULL,
	PRIMARY KEY ('nume')
);

CREATE TABLE 'examens' (
	'tipExamen' VARCHAR(255) NOT NULL,
	'medieExamen' VARCHAR(255) NOT NULL
);

CREATE TABLE 'facultati' (
	'nume' VARCHAR(255) NOT NULL,
	'locatie' VARCHAR(255) NOT NULL,
	'numarTotalLocuri' VARCHAR(255) NOT NULL,
	PRIMARY KEY ('nume')
);



