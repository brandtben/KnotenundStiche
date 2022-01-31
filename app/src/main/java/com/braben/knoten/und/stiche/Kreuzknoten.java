package com.braben.knoten.und.stiche;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Halbschlag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Halbschlag#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Kreuzknoten extends Fragment implements Button.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button wButton;
    private Button zButton;

    int index = 1;
    int[] imgsrc = {R.drawable.kreuz1, R.drawable.kreuz2, R.drawable.kreuz3, R.drawable.kreuz4, R.drawable.kreuz5, R.drawable.kreuz6, R.drawable.kreuz6};
    int[] texsrc = {R.string.kreuz1, R.string.kreuz2, R.string.kreuz3, R.string.kreuz4, R.string.kreuz5, R.string.kreuz6, R.string.kreuz6};


    public static Kreuzknoten newInstance(int section_number) {
        Kreuzknoten fragment = new Kreuzknoten();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }

    public Kreuzknoten() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kreuzknoten, container, false);
        wButton = (Button) rootView.findViewById(R.id.kreuzw);
        wButton.setOnClickListener(this);
        zButton = (Button) rootView.findViewById(R.id.kreuzz);
        zButton.setOnClickListener(this);
        zButton.setVisibility(View.INVISIBLE);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((Main) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.kreuzw) kreuzweiter(getView());
        if (view.getId() == R.id.kreuzz) kreuzzurueck(getView());
    }

    public void kreuzweiter(View view)
    {

        ImageView img = (ImageView) getView().findViewById(R.id.kreuzimg);
        img.setImageResource(imgsrc[index]);
        Button butw = (Button) getView().findViewById(R.id.kreuzw);
        Button butz = (Button) getView().findViewById(R.id.kreuzz);

        TextView tex = (TextView) getView().findViewById(R.id.kreuztxt);
        tex.setText(texsrc[index]);

        if (index == imgsrc.length-2)
        {
            butw.setVisibility(View.INVISIBLE);
            butw.setText(R.string.fertig);
        }

        if (index == imgsrc.length-1)
        {
            index = 1;
            butw.setVisibility(View.INVISIBLE);

        }
        if (index == 1)
        {
            butz.setVisibility(View.VISIBLE);
            index ++;
        }

        else
        {
            index++;
        }
    }

    public void kreuzzurueck(View view)
    {
        index = index - 1;
        ImageView img = (ImageView) getView().findViewById(R.id.kreuzimg);
        TextView tex = (TextView) getView().findViewById(R.id.kreuztxt);
        Button butw = (Button) getView().findViewById(R.id.kreuzw);
        Button butz = (Button) getView().findViewById(R.id.kreuzz);

        butw.setClickable(true);


        if (index == imgsrc.length-2)
        {

            butw.setText(R.string.weiter);
        }

        if (index == 1)
        {
            butz.setVisibility(View.INVISIBLE);
            img.setImageResource(imgsrc[index-1]);
            tex.setText(texsrc[index-1]);
        }
        else
        {
            butw.setVisibility(View.VISIBLE);
            img.setImageResource(imgsrc[index-1]);
            tex.setText(texsrc[index-1]);
        }
    }
}


