package zad2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {

	@FXML
	private Button ButtonZSynchronizacja;

	@FXML
	private Button ButtonBezSynchronizacji;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	void ActionBezSynchronizacji(ActionEvent event) {
		Thread thread1 = new Thread() {
			public void run() {
				wypisz("1",label2);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				wypisz("2",label2);
			}
		};
		thread1.start();
		thread2.start();
	}

	@FXML
	void ActionZSynchronizacja(ActionEvent event) {
		Thread thread1 = new Thread() {
			public void run() {
				wypiszSynchronization("1",label1);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				wypiszSynchronization("2",label1);
			}
		};
		thread1.start();
		thread2.start();
	}

	public synchronized static void wypiszSynchronization(String text,Label label) {
		Platform.runLater(new Runnable() {
			@Override public void run() {
				for (int x = 0; x < 10; x++) {
					label.setText(label.getText() + text);

					//System.out.println(text);
				}
			}
		});

	}

	public static void wypisz(String text,Label label) {
		Platform.runLater(new Runnable() {
			@Override public void run() {
				for (int x = 0; x < 10; x++) {
					label.setText(label.getText() + text);

					//System.out.println(text);
				}
			}
		});

	}
}