package com.linhnguyen.sortoe;

import java.lang.reflect.Array;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText edtArray;
	TextView txtArray;
	Button btnSort;
	public static ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtArray = (EditText) findViewById(R.id.edtArray);
		txtArray = (TextView) findViewById(R.id.txtArray);
		btnSort = (Button) findViewById(R.id.btnSort);

		btnSort.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String arr = edtArray.getText().toString();

				final String array[] = arr.split(" ");
				final int[] arrayInt = convert(array);
				int i = 0;
				for (i = 0; i < array.length; i++) {
					if (i == 0 && arrayInt[i] % 2 == 0) {

					} else {
						if (arrayInt[i] % 2 == 0) {

							if (arrayInt[i - 1] % 2 != 0) {
								int temp2 = arrayInt[i];
								arrayInt[i] = arrayInt[i - 1];
								arrayInt[i - 1] = temp2;

								int now = i - 1;
								int pre = now - 1;
								if (pre >= 0) {
									while (arrayInt[pre] % 2 != 0) {
										int temp3 = arrayInt[pre + 1];
										arrayInt[pre + 1] = arrayInt[pre];
										arrayInt[pre] = temp3;
										pre = pre - 1;
										if (pre < 0) {
											break;
										}
									}
								}
							}

						}
					}

				}
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < arrayInt.length; j++) {
					sb.append(arrayInt[j]);
				}
				txtArray.setText(sb.toString());

			}
		});
	}

	public void swap(int saveLastOdd, int nowEven) {
		int temp2 = nowEven;
		nowEven = saveLastOdd;
		saveLastOdd = temp2;
	}

	private int[] convert(String[] tring) { // Note the [] after the
		// String.
		int number[] = new int[tring.length];

		for (int i = 0; i < tring.length; i++) {
			number[i] = Integer.parseInt(tring[i]);
		}
		return number;
	}

}
