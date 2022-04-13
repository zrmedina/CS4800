CREATE TABLE public.Song ( 
                Title VARCHAR NOT NULL, 
                Length INTEGER NOT NULL, 
                CONSTRAINT title PRIMARY KEY (Title) 
); 
  
  
CREATE TABLE public.Instrument ( 
                Name VARCHAR NOT NULL, 
                Pitch INTEGER NOT NULL, 
                CONSTRAINT name PRIMARY KEY (Name) 
); 
  
  
CREATE SEQUENCE public.address_addressid_seq_1; 
  
CREATE TABLE public.Address ( 
                AddressID INTEGER NOT NULL DEFAULT nextval('public.address_addressid_seq_1'), 
                Number INTEGER NOT NULL, 
                Street1 VARCHAR NOT NULL, 
                Street2 VARCHAR, 
                City VARCHAR NOT NULL, 
                State VARCHAR NOT NULL, 
                ZipCode INTEGER NOT NULL, 
                Telephone INTEGER NOT NULL, 
                CONSTRAINT address_id PRIMARY KEY (AddressID) 
); 
  
  
ALTER SEQUENCE public.address_addressid_seq_1 OWNED BY public.Address.AddressID; 
  
CREATE TABLE public.Musician ( 
                SSN INTEGER NOT NULL, 
                AddressID INTEGER NOT NULL, 
                Name VARCHAR NOT NULL, 
                CONSTRAINT ssn PRIMARY KEY (SSN) 
); 
  
  
CREATE SEQUENCE public.song_list_id_seq; 
  
CREATE TABLE public.Song_List ( 
                id INTEGER NOT NULL DEFAULT nextval('public.song_list_id_seq'), 
                Title VARCHAR NOT NULL, 
                SSN INTEGER NOT NULL, 
                PublishDate DATE NOT NULL, 
                CONSTRAINT id PRIMARY KEY (id, Title, SSN) 
); 
  
  
ALTER SEQUENCE public.song_list_id_seq OWNED BY public.Song_List.id; 
  
CREATE SEQUENCE public.set_list_id_seq; 
  
CREATE TABLE public.Set_List ( 
                id INTEGER NOT NULL DEFAULT nextval('public.set_list_id_seq'), 
                SSN INTEGER NOT NULL, 
                Title VARCHAR NOT NULL, 
                PerformDate DATE NOT NULL, 
                CONSTRAINT id PRIMARY KEY (id, SSN, Title) 
); 
  
  
ALTER SEQUENCE public.set_list_id_seq OWNED BY public.Set_List.id; 
  
CREATE SEQUENCE public.album_albumid_seq; 
  
CREATE TABLE public.Album ( 
                AlbumID INTEGER NOT NULL DEFAULT nextval('public.album_albumid_seq'), 
                Title VARCHAR NOT NULL, 
                Release_Date DATE NOT NULL, 
                Format VARCHAR NOT NULL, 
                Age INTEGER NOT NULL, 
                SSN INTEGER NOT NULL, 
                CONSTRAINT albumid PRIMARY KEY (AlbumID) 
); 
  
  
ALTER SEQUENCE public.album_albumid_seq OWNED BY public.Album.AlbumID; 
  
CREATE SEQUENCE public.instrumentlist_id_seq; 
  
CREATE TABLE public.InstrumentList ( 
                id INTEGER NOT NULL DEFAULT nextval('public.instrumentlist_id_seq'), 
                SSN INTEGER NOT NULL, 
                Name VARCHAR NOT NULL, 
                CONSTRAINT id PRIMARY KEY (id, SSN, Name) 
); 
  
  
ALTER SEQUENCE public.instrumentlist_id_seq OWNED BY public.InstrumentList.id; 
  
ALTER TABLE public.Set_List ADD CONSTRAINT song_set_list_fk 
FOREIGN KEY (Title) 
REFERENCES public.Song (Title) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.Song_List ADD CONSTRAINT song_song_list_fk 
FOREIGN KEY (Title) 
REFERENCES public.Song (Title) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.InstrumentList ADD CONSTRAINT instrument_instrumentlist_fk 
FOREIGN KEY (Name) 
REFERENCES public.Instrument (Name) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.Musician ADD CONSTRAINT address_musician_fk 
FOREIGN KEY (AddressID) 
REFERENCES public.Address (AddressID) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.InstrumentList ADD CONSTRAINT musician_instrumentlist_fk 
FOREIGN KEY (SSN) 
REFERENCES public.Musician (SSN) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.Album ADD CONSTRAINT musician_album_fk 
FOREIGN KEY (SSN) 
REFERENCES public.Musician (SSN) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.Set_List ADD CONSTRAINT musician_set_list_fk 
FOREIGN KEY (SSN) 
REFERENCES public.Musician (SSN) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 
  
ALTER TABLE public.Song_List ADD CONSTRAINT musician_song_list_fk 
FOREIGN KEY (SSN) 
REFERENCES public.Musician (SSN) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION 
NOT DEFERRABLE; 