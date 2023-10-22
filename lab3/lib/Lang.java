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
		this.messageList.put("APPLICATION_COMMAND_IS_NOT_VALID", "Команда введена некорректно.");
		this.messageList.put("APPLICATION_COMMAND_NOT_FOUND", "Введенная команда не найдена.");
		this.messageList.put("APPLICATION_INDEX_IS_NOT_VALID", "Введенная номер введен некорректно.");
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
