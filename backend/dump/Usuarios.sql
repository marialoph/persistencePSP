CREATE TABLE IF NOT EXISTS Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    token VARCHAR(100)
);
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (1, 'maria', 'f5e2e0d5a6bc059d8d1cae6d68776a1e4ca9fcd4172b26fd75e16a5a0135b94f', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (2, 'pedro', '6b9b3bbbc92f9edc6ae8f5fdbe846bfa7e1b941ce003f0ccbf0b4f01792f8d7b', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (3, 'luisa', 'd51e9d44365d903875d1787032e6c8a915ccf1699114c24b8d6f739fc8e1f858', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (4, 'jorge', 'f815a98f472e25f8b51f903cc8c5b0be2c564c89dbdb799a3b9a74527467d7cc', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (5, 'ana', '3cfcd46f8d6230d6206be7d8bfa6ec0645c06b19cc5b8f8ed2fd78a6d6795abf', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (6, 'luis', 'b8d2a11e7ac10da9b2f89ed9dbbe91fbc021dfdb244fe23047e120f60d8fc7d6', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (7, 'sofia', '964c5f6f7f944029ff7f02b1cb6f61eecce84f303fb9a380ebd11b49b7e29b4e', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (8, 'carlos', '9b88fc6ff5b76dbb3a4b7b1c27a6e0734566ff72fc27f70c3c1a8fe77deec94b', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (9, 'rebecca', '9f0b8699ed33e9caa3a7275853c039d28ecf60cd8c07888d7b465cb45a1f26c0', '');
INSERT INTO Usuarios (id, nombre, contrasena, token) VALUES (10, 'andres', '83fe4e8bc595578d362295d2e97be22189a29989c00a29e039877d7a340f5f4d', '');

