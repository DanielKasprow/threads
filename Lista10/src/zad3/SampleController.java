package zad3;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {

	@FXML
	private Button ButtonZWatkami;

	@FXML
	private Button ButtonBezWatkow;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

	@FXML
	private Label label4;

	ArrayList<Integer> ListaArray1 = new ArrayList<Integer>();
	ArrayList<Integer> ListaArray2 = new ArrayList<Integer>();
	ArrayList<Integer> ListaArray3 = new ArrayList<Integer>();

	@FXML
	void ActionBezWatek(ActionEvent event) {
		losuj();
		Clock clock = Clock.systemDefaultZone();
		long czasstart = clock.millis();
		Collections.sort(ListaArray1);
		Collections.sort(ListaArray2);
		Collections.sort(ListaArray3);
		long czaskoniec = clock.millis();
		label2.setText(((czaskoniec - czasstart) / 1000.0) + " s");
	}

	@FXML
	void ActionZwatkami(ActionEvent event) {
		losuj();
		Clock clock = Clock.systemDefaultZone();
		Thread thread1 = new Thread() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						long czasstart = clock.millis();
						Collections.sort(ListaArray1);
						long czaskoniec = clock.millis();

						label1.setText(((czaskoniec - czasstart) / 1000.0) + " s");
					}
				});

			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						long czasstart = clock.millis();
						Collections.sort(ListaArray2);
						long czaskoniec = clock.millis();

						label3.setText(((czaskoniec - czasstart) / 1000.0) + " s");
					}
				});

			}
		};
		Thread thread3 = new Thread() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						long czasstart = clock.millis();
						Collections.sort(ListaArray3);
						long czaskoniec = clock.millis();

						label4.setText(((czaskoniec - czasstart) / 1000.0) + " s");
					}
				});

			}
		};
		// long czasstart = clock.millis();
		thread1.start();
		thread2.start();
		thread3.start();
		// thread1.join();
		// thread2.join();
		// thread3.join();
		// long czaskoniec = clock.millis();
		// label1.setText(((czaskoniec - czasstart) / 1000.0) + " s");
	}

	private void runOnUiThread(Runnable runnable) {
		// TODO Auto-generated method stub

	}

	void losuj() {
		Random generator = new Random();
		int rand = 0;
		for (int x = 0; x < 1000000; x++) {
			rand = generator.nextInt(10000);
			ListaArray1.add(rand);
			rand = generator.nextInt(10000);
			ListaArray2.add(rand);
			rand = generator.nextInt(10000);
			ListaArray3.add(rand);
		}
	}

}