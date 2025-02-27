CREATE TABLE Musica (
    nombre VARCHAR(255) PRIMARY KEY,
    generoMusical VARCHAR(100),
    albums VARCHAR(50),
    fechaNacimiento VARCHAR(100),
    image TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla de artistas y su música';


INSERT INTO Musica (nombre, generoMusical, albums, fechaNacimiento, image) VALUES
('Adele', 'soul y pop', 'Nº Albums: 4', '1988-05-05', 'https://www.billboard.com/wp-content/uploads/2024/07/adele-las-vegas-residency-2022-billboard-espanol-1548.jpg'),
('Dua Lipa', 'pop', 'Nº Albums: 3', '1995-08-22', 'https://media.emisorasmusicales.net/wp-content/uploads/2024/02/19154351/Dua-Lipa-Training-Season-emisora-musicales-2024.webp'),
('Coldplay', 'pop rock', 'Nº Albums: 5', '1977-03-02', 'https://i.scdn.co/image/ab6761610000e5eb1ba8fc5f5c73e7e9313cc6eb'),
('Gracie Abrams', 'bedroom pop', 'Nº Albums: 2', '1999-09-07', 'https://cdn-images.dzcdn.net/images/artist/caae80ef38cbf1c87106a1459c2f6511/500x500.jpg'),
('Billie Eilish', 'pop', 'Nº Albums: 3', '2001-12-18', 'https://static.wikia.nocookie.net/totallyspies/images/8/8e/Billie_Eilish.png/revision/latest?cb=20240424083540'),
('Tom Odell', 'indie', 'Nº Albums: 5', '1990-11-24', 'https://rytmy.pl/wp-content/uploads/2021/11/Tom-Odell.jpg'),
('Sabrina Carpenter', 'pop', 'Nº Albums: 6', '1999-05-11', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkZ76tQOAWiYbr4cKw67fuXkqsToE6-4sETQ&s'),
('Lana del Rey', 'indie pop', 'Nº Albums: 9', '1985-06-21', 'https://hips.hearstapps.com/hmg-prod/images/lana-del-rey-vestido-grammys-1580138676.jpg?crop=1xw:0.84375xh;center,top&resize=1200:*'),
('Olivia Rodrigo', 'pop', 'Nº Albums: 2', '2003-02-20', 'https://akamai.sscdn.co/uploadfile/letras/fotos/5/7/e/e/57eee911b0da5b7af22c17f3bfda611a.jpg');

