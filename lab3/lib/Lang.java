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
		this.messageList.put("APPLICATION_START_MESSAGE", "Стартовое сообщение"); //TODO(дописать)
		this.messageList.put("APPLICATION_COMMAND_IS_NOT_VALID", "Команда введена некорректно.");
		this.messageList.put("APPLICATION_COMMAND_NOT_FOUND", "Введенная команда не найдена.");
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
