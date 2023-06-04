# MovieRESTAPI

РЕГИСТРАЦИЯ
POST: http://localhost:8080/api/auth/signup
Body:
{
    "email": "max.belov.s4@gmail.com",
    "password": "MaxWhite2002",
    "username": "MaxWhite"
}


АВТОРИЗАЦИЯ
POST: http://localhost:8080/api/auth/signin
BODY:
{
    "password": "MaxWhite2002",
    "username": "MaxWhite"
}
ДОБАВЛЕНИЕ ФИЛЬМА
POST: http://localhost:8080/api/test/user/addmovie
BODY:

{
    "title": "TEST MOVIE",
    "genre": "Action",
    "details": "Description.",
    "release_date":"2023-06-04"
}

ПОИСК ФИЛЬМА ПО ID
GET: http://localhost:8080/api/test/user/getmovie?id={id}

