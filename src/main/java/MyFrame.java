import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

  //  Calendar calendar; // как таковой класс "календарь" инициализировать смысла нет:
    // изначально добавил его, чтобы сразу подключить зависимости для блока "setTime"
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock App");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("HH:mm:ss"); // 24 часовой формат
        dayFormat = new SimpleDateFormat("EEEE"); // день недели
        dateFormat = new SimpleDateFormat("dd MMMM, yyyy"); // день, месяц, год

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x11FF00));
        timeLabel.setBackground(Color.BLACK); // если мы ограничимся только указанием цвета бэкграунда, результат мы не увидим, тк идет перекрытие цветов, а значит нам нужно сделать прозрачность
        timeLabel.setOpaque(true); // выставляем прозрачность на true: теперь бэкграунд отображается черным цветом

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.BOLD, 35));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.BOLD, 35));


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime(); // создаю метод для обновления времени, в противном случае часы будут показывать статическое время
                   // запуска программы
                   //  метод устанавливает текст для timeLabel, dayLabel и dateLabel
    }
    public void setTime(){
        while (true) { // для бесконечного обновления секунд использую метод while
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

        try {
            Thread.sleep(1000);
            /* Добавление Thread.sleep(1000); в цикл позволяет приложению делать паузу на 1 секунду между обновлениями времени,
            что более эффективно с точки зрения использования ресурсов. В общем и в целом, такое простое приложение
            будет стабильно работать и исключительно на цикле while.
            Так же, если будет необходимость добавить в приложение дополнительный функционал, то его логика пойдет
            отдельной нитью.
            В отсутствие необходимости, весь данный блок try-catch можно смело убрать без особых последствий.
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
            }

        }
    }
}
