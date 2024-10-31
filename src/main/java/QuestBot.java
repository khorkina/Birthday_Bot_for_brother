import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class QuestBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "name"; // Замените на имя вашего бота
    }

    @Override
    public String getBotToken() {
        return "token"; // Замените на токен вашего бота
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            String userMessage = message.getText();

            String response;
            switch (userMessage.toLowerCase()) {
                case "/start":
                    response = "Привет! Добро пожаловать в квест! Напиши 'начать', чтобы испытать себя!";
                    break;
                case "начать":
                    response = "Загадка 1: Какое слово начинается с трех букв «Г» и заканчивается тремя буквами «Я»?\n";
                    break;
                case "тригонометрия":
                    response = "Правильно! Двигаемся дальше.\n";
                    response += "Загадка 2: Что может в одно и то же время: стоять и ходить, висеть и стоять, ходить и лежать?\n";
                    break;
                case "часы":
                    response = "Отлично! Ты явно мастер разгадок!\n";
                    response += "Загадка 3: Это дается нам трижды. Первые два раза бесплатно. А вот за третий придется заплатить.\n";
                    break;
                case "зубы":
                    response = "Верно! Вот это логика! Переходим дальше.\n";
                    response += "Загадка 4: По правилам пользования, грузовой лифт в гостинице вмещает и может перевезти не более 15 взрослых или не более 20 детей.\n" +
                            "\n" +
                            "Вопрос: Какое наибольшее число детей может ехать в лифте с шестью взрослыми?\n";
                    break;
                case "12":
                    response = "Ты просто гений! Похоже, загадки — твоя сильная сторона!\n";
                    response += "Финальная загадка: В квартире живут домашние животные: собаки и кошки. Из всех животных только одно не является собакой, при этом все питомцы, кроме одного, — кошки. Сколько всего кошек и собак?\n";
                    break;
                case "2":
                    response = "Поздравляю! Ты прошел весь квест и показал свою сообразительность! " +
                            "No problems было чтоб всегда,\n" +
                            "Прикрыта другом чтоб спина,\n" +
                            "Харизма — та еще граната —\n" +
                            "У моего родного брата.\n" +
                            "\n" +
                            "Be happy каждую минуту —\n" +
                            "Тогда все в жизни будет круто.\n" +
                            "Желаем чудо-настроения,\n" +
                            "Пусть будет лучшим день рождения!\n";
                    break;
                default:
                    response = "Неверный выбор. Не отчаивайся! Попробуй еще раз.";
            }

            sendTextMessage(chatId, response);
        }
    }

    private void sendTextMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}