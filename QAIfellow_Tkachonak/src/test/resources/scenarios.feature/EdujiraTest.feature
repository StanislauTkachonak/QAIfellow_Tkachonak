# language: ru

Функция: Работа с задачами на сайте https://edujira.ifellow.ru/

  Сценарий: Авторизация на сайте, проверка количества задач в проекте и создание бага

    Когда Ввод логина и пароля 'AT3', 'Qwerty123'
    Тогда Открывается главная страница сайта c заголовком 'System Dashboard'

    Дано Вход в раздел проекты, проверка количества задач, путем создания новой с темой - 'HW3'

    Дано Клик на задачу 'TestSeleniumATHomework'
    Дано Проверка статуса: 'СДЕЛАТЬ'
    Дано Проверка версии: 'Version 2.0'

    Когда Создание бага с указанием в поле тип: 'Ошибка'
    И Ввод темы бага 'HW3'
    И Ввод описания бага 'Некорректное отображение текста на странице при использовании масштабирования'
    Тогда Изменение статуса на Выполнено


