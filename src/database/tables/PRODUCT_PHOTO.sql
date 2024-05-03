CREATE TABLE PRODUCT_PHOTO (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    URL VARCHAR(300) NOT NULL,
    THUMB BIT NOT NULL,
    ID_PRODUCT INT NOT NULL,
    FOREIGN KEY (ID_PRODUCT) REFERENCES PRODUCT(ID)
)