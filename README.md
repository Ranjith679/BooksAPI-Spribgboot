📚 Book Management API
A simple Spring Boot CRUD application to manage books.
You can create, read, update, and delete books using REST APIs.

🚀 Features
Home Endpoint → Welcome message

Add Book → Create a new book

Get All Books → Fetch all stored books

Get Book by ID → Find a book by its ID

Update Book → Update existing book details

Delete Book → Remove a book by ID

⚙️ Tech Stack
Java 17+

Spring Boot 3+

Spring Data JPA

Hibernate

H2 / MySQL (configurable)

📌 Endpoints
Method	Endpoint	Description
GET	/	Home message
GET	/books	Fetch all books
GET	/book/{id}	Fetch book by ID
POST	/addBook	Add new book
PUT	/book/{id}	Update book by ID
DELETE	/book/{id}	Delete book by ID
