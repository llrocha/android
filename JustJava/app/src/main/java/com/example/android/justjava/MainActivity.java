/**
 * IMPORTANT: Make sure you are using the correct package mName.
 * This example uses the package mName:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package mName found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity;
    private String mName;
    private boolean hasWhippedCream;
    private boolean hasChocolate;
    private String[] emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whippedCreamCheckBox);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolateCheckBox);
        EditText textInputName = (EditText)findViewById(R.id.name);

        mName = textInputName.getText().toString();
        hasWhippedCream = whippedCreamCheckBox.isChecked();
        hasChocolate = chocolateCheckBox.isChecked();

        String message = calculateOrder(mName, hasWhippedCream, hasChocolate, quantity);

        emails = new String[1];
        emails[0] = "leonardolpi@gmail.com";
        //composeEmail(emails, "Just Java order for " + mName, message);
        //displayOrderSummary(message);
        capturePhoto("teste.jpg");
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final Uri mLocationForPhotos = new Uri("file:///tmp/");

    public void capturePhoto(String targetFilename) {
        //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //intent.putExtra(MediaStore.EXTRA_OUTPUT,
        //        Uri.withAppendedPath(mLocationForPhotos, targetFilename));
        //if (intent.resolveActivity(getPackageManager()) != null) {
        //    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        //}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap thumbnail = data.getParcelableExtra("data");

            Uri fullPhotoUri = data.getData();
            // Do other work with full size photo saved in mLocationForPhotos
            displayOrderSummary(fullPhotoUri.toString());
        }
    }

    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public String calculateOrder(String name, boolean hasWhippedCream, boolean hasChocolate, int quantity) {

        String message = "Name: " + name;
        message = message + "\nAdd whipped cream? " + hasWhippedCream;
        message = message + "\nAdd chocolate? " + hasChocolate;
        message = message + "\nQuantity: " + quantity;
        message = message + "\nTotal: " + calculatePrice(hasWhippedCream, hasChocolate);
        message = message  + "\nThank you!";

        return message;
    }

    public int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;

        if(hasChocolate) {
            basePrice  += 2;
        }

        if(hasWhippedCream) {
            basePrice  += 1;
        }

        return (quantity * basePrice);
    }

    /**x
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if(quantity < 100) {
            quantity++;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
        }
        //displayOrderSummary("" + (quantity * price));
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity > 1) {
            quantity--;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
        //displayOrderSummary("" + (quantity * price));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayOrderSummary(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}