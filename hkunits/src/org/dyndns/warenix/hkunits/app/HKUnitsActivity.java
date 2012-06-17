package org.dyndns.warenix.hkunits.app;

import org.dyndns.warenix.hkunits.MassConvertor;
import org.dyndns.warenix.hkunits.R;
import org.dyndns.warenix.hkunits.units.mass.Cash;
import org.dyndns.warenix.hkunits.units.mass.Catty;
import org.dyndns.warenix.hkunits.units.mass.Gram;
import org.dyndns.warenix.hkunits.units.mass.Kilogram;
import org.dyndns.warenix.hkunits.units.mass.Kilogramable;
import org.dyndns.warenix.hkunits.units.mass.Mace;
import org.dyndns.warenix.hkunits.units.mass.Mass;
import org.dyndns.warenix.hkunits.units.mass.Ounce;
import org.dyndns.warenix.hkunits.units.mass.Pounds;
import org.dyndns.warenix.hkunits.units.mass.Tael;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class HKUnitsActivity extends SherlockFragmentActivity implements
		TextWatcher, OnItemSelectedListener {
	private static final String TAG = "ChineseunitsActivity";

	protected Spinner mFromUnitSpinner;
	protected Spinner mToUnitSpinner;

	protected EditText mFromValue;
	protected TextView mToValue;

	protected ArrayAdapter<CharSequence> mFromUnitAdapter;
	protected ArrayAdapter<CharSequence> mToUnitAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setupUI();
		initUnits();
		testMass();
	}

	void setupUI() {
		mFromUnitSpinner = (Spinner) findViewById(R.id.from_unit);
		mToUnitSpinner = (Spinner) findViewById(R.id.to_unit);
		mFromValue = (EditText) findViewById(R.id.from_value);
		mToValue = (TextView) findViewById(R.id.to_value);

		mFromUnitSpinner.setOnItemSelectedListener(this);
		mToUnitSpinner.setOnItemSelectedListener(this);

		mFromValue.addTextChangedListener(this);
	}

	protected void initUnits() {
		mToUnitAdapter = ArrayAdapter.createFromResource(this,
				R.array.mass_units_array, android.R.layout.simple_spinner_item);
		mToUnitAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mToUnitSpinner.setAdapter(mToUnitAdapter);

		mFromUnitAdapter = ArrayAdapter.createFromResource(this,
				R.array.mass_units_array, android.R.layout.simple_spinner_item);
		mFromUnitAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mFromUnitSpinner.setAdapter(mFromUnitAdapter);
	}

	void testMass() {
		Kilogramable k = null;
		Kilogram kg = null;

		k = new Catty(10.0);
		kg = k.toKilogram();
		Log.d(TAG, String.format("%s = %s", k, kg));

		k = new Gram(10.0);
		kg = k.toKilogram();
		Log.d(TAG, String.format("%s = %s", k, kg));

		k = new Kilogram(10.0);
		kg = k.toKilogram();
		Log.d(TAG, String.format("%s = %s", k, kg));

		k = new Pounds(10.0);
		kg = k.toKilogram();
		Log.d(TAG, String.format("%s = %s", k, kg));

		k = new Tael(10.0);
		kg = k.toKilogram();
		Log.d(TAG, String.format("%s = %s", k, kg));

		Kilogramable from = new Ounce(1.0);
		Kilogramable to = new Ounce(1.0);
		Kilogram result = MassConvertor.convert(from, to);

		Log.d(TAG,
				String.format("%s -> %s = %s = %s", from, to, result,
						to.fromKilogram(result)));
	}

	protected void convertUnit() {
		try {
			double fromValue = Double.parseDouble(mFromValue.getText()
					.toString());
			String fromUnit = (String) mFromUnitSpinner.getSelectedItem();
			String toUnit = (String) mToUnitSpinner.getSelectedItem();

			Log.d(TAG, String.format("convert %f %s to %s", fromValue,
					fromUnit, toUnit));

			// create objects
			int fromUnitPosition = mFromUnitSpinner.getSelectedItemPosition();
			int toUnitPosition = mToUnitSpinner.getSelectedItemPosition();

			Kilogramable from = createKilogramableFromPosition(
					fromUnitPosition, fromValue);
			Kilogramable to = createKilogramableFromPosition(toUnitPosition,
					1.0);
			Kilogram kg = MassConvertor.convert(from, to);
			Mass result = (Mass) to.fromKilogram(kg);
			mToValue.setText("" + result.getValue());
		} catch (NumberFormatException e) {
			mToValue.setText(null);
		}
	}

	Kilogramable createKilogramableFromPosition(int position, double value) {
		switch (position) {
		case 0:
			return new Catty(value);
		case 1:
			return new Tael(value);
		case 2:
			return new Kilogram(value);
		case 3:
			return new Gram(value);
		case 4:
			return new Pounds(value);
		case 5:
			return new Ounce(value);
		case 6:
			return new Mace(value);
		case 7:
			return new Cash(value);
		}
		return null;
	}

	@Override
	public void afterTextChanged(Editable view) {
	}

	@Override
	public void beforeTextChanged(CharSequence text, int arg1, int arg2,
			int arg3) {

	}

	@Override
	public void onTextChanged(CharSequence text, int arg1, int arg2, int arg3) {
		convertUnit();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		convertUnit();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}