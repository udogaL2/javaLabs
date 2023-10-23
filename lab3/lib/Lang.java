package lib;

import java.util.HashMap;
import java.util.Map;

public class Lang
{
	Map<String, String> messageList;

	public Lang()
	{
		this.messageList = new HashMap<String, String>();

		this.init();
	}

	private void init()
	{
		this.messageList.put("APPLICATION_TITLE",
			"""
			████─█──█───██─███─███─█──█─████─████────████─█──█─████─███─███─█───█─████────█─█──█───████─████─
			█────█──█──█─█─█────█──█──█─█──█─█──█────█──█─█──█─█──█──█──█───██─██─█──█────█─█─██───█──█─█──██
			████─█─██─█──█─███──█──████─████─████────█────█─██─█─────█──███─█─█─█─████────█─█──█───█──█─████─
			█──█─██─█─█──█─█────█──█──█─█──█──█─█────█──█─██─█─█──█──█──█───█───█─█──█────███──█───█──█─█──██
			████─█──█─█──█─███──█──█──█─█──█──█─█────████─█──█─████──█──███─█───█─█──█─────█───█─█─████─████─
			
			Для перехода по вкладкам укажите номер пункта меню.
			
			Войти как:
			1. Посетитель
			2. Администратор
			
			0. Выйти из приложения
			"""
		);
		this.messageList.put("APPLICATION_LOGIN_AS_ADMIN", "Вы вошли как администратор.");
		this.messageList.put("APPLICATION_LOGIN_AS_USER", "Вы вошли как посетитель.");
		this.messageList.put("APPLICATION_COMMAND_IS_NOT_VALID", "Данные введены некорректно.");
		this.messageList.put("APPLICATION_COMMAND_NOT_FOUND", "Введенная команда не найдена.");
		this.messageList.put("APPLICATION_INDEX_IS_NOT_VALID", "Номер введен некорректно.");
		this.messageList.put("APPLICATION_EMPTY_LIST", "Запрашиваемый список пуст.");
		this.messageList.put("APPLICATION_USER_INPUT", "--> ");

		this.messageList.put("APPLICATION_ADMIN_COMMAND_LIST",
  			"""
			Доступные команды для администратора:
			1. Кинотеатры
			2. Кинозалы
			3. Фильмы
			4. Сеансы
			5. Кресла
			
			0. Выйти в меню выбора роли
			"""
		);
		this.messageList.put("APPLICATION_ADMIN_CINEMA_COMMAND_LIST",
			"""
			Доступные команды для кинотеатров:
			1. Посмотреть текущий список
			2. Создать
			3. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_CINEMA_LIST", "Текущий список кинотеатров:");
		this.messageList.put("APPLICATION_USER_COMMAND_LIST",
			"""
			Доступные команды для посетителя:
			1. Фильмы
			2. Кинотеатры
			
			0. Выйти в меню выбора роли
			"""
		);

		this.messageList.put("APPLICATION_GET_CINEMA_TITLE", "Введите название кинотеатра.");
		this.messageList.put("APPLICATION_GET_CINEMA_INDEX_TO_DELETE", "Введите номер кинотеатра, который хотите удалить.");

		this.messageList.put("APPLICATION_CINEMAHALL_LIST", "Текущий список кинозалов:");
		this.messageList.put("APPLICATION_ADMIN_CINEMAHALL_COMMAND_LIST",
			"""
			Доступные команды для кинозалов:
			1. Посмотреть текущий список для конкретного кинотеатра
			2. Посмотреть схему кинозала
			3. Создать
			4. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_GET_CINEMAHALL_CINEMA_ID", "Введите номер кинотеатра, для которого хотите увидеть список кинозалов.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ID", "Введите номер кинозала, для которого хотите увидеть схему.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_EMPTY_CINEMA_LIST", "Для создания нового кинозала необходимо, чтобы был создан хотя бы один кинотеатр.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_TITLE", "Введите название кинозала.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ROW_COUNT", "Введите количество рядов кинозала.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ROW_COUNT_NOT_VALID", "Введите количество рядов кинозала не может быть равным нулю.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_CINEMA_ID_TO_ADD", "Введите номер кинотеатра, в который хотите добавить этот кинозал.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_INDEX_TO_DELETE", "Введите номер кинозала, который хотите удалить.");

		this.messageList.put("APPLICATION_ADMIN_FILM_COMMAND_LIST",
				"""
				Доступные команды для фильмов:
				1. Посмотреть текущий список фильмов
				2. Создать
				3. Удалить
				
				0. Выйти в меню выбора команд
				"""
		);
		this.messageList.put("APPLICATION_FILM_LIST", "Текущий список фильмов:");
		this.messageList.put("APPLICATION_FILM_GET_TITLE", "Введите название фильма.");
		this.messageList.put("APPLICATION_FILM_GET_DESCRIPTION", "Введите короткое описание фильма (не более 256 символов).");
		this.messageList.put("APPLICATION_FILM_GET_DURATION", "Введите продолжительность фильма в минутах.");
		this.messageList.put("APPLICATION_FILM_INPUT_DURATION_ERROR", "Продолжительность не может быть отрицательной");
		this.messageList.put("APPLICATION_GET_FILM_INDEX_TO_DELETE", "Введите номер фильма, который хотите удалить.");
	}

	public String getMessage(String messageCode)
	{
		if (this.messageList.isEmpty() || !this.messageList.containsKey(messageCode))
		{
			return "";
		}

		return this.messageList.get(messageCode);
	}
}
