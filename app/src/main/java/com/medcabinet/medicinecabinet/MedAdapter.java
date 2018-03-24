package com.medcabinet.medicinecabinet;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by demouser on 3/24/18.
 */

public class MedAdapter extends ArrayAdapter<Medicine> {

    /**
     * Resource ID for the background color for the list of words
     */

    private int mColorResourceId;


    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param wordBlock       A list of Word objects to display in a list
     */
    public MedAdapter(Activity context, ArrayList<Medicine> wordBlock, int colorResourceId){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordBlock);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     *
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Medicine currentMiwokWord = getItem(position);

        Medicine currentDefaultWord = getItem(position);

        Medicine currentImage = getItem(position);

        // Find the TextView in the list_item.xml layout with the miwok_text_view
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
//        miwokTranslationTextView.setText(currentMiwokWord.getmMiwokTranslation());
//
//
//        // Find the TextView in the list_item.xml layout with the default_text_view
//        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        defaultTranslationTextView.setText(currentDefaultWord.getmDefaultTranslation());
//
//
//        // Find the ImageView in the list_item.xml layout with the ID image
//        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
//        // Get the image resource ID from the current Word object and
//        // set the image to imageView
//        imageView.setImageResource(currentImage.getmImageResourceId());
        // Return the whole list item layout
        // so that it can be shown in the ListView

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown
        // int the listView

        return listItemView;
    }


}
