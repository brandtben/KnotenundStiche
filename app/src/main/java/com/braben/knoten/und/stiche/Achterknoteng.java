package com.braben.knoten.und.stiche;

import android.app.Activity;
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
public class Achterknoteng extends Fragment implements Button.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button wButton;
    private Button zButton;

    int index = 1;

    int[] imgsrc = {R.drawable.achter_gelegt1,R.drawable.achter_gelegt3,R.drawable.achter_gelegt4,R.drawable.achter_gelegt5,R.drawable.achter_gelegt6,R.drawable.achter_gelegt7,R.drawable.achter_gelegt7};
    int[] texsrc = {R.string.achter_gelegt1,R.string.achter_gelegt2,R.string.achter_gelegt3,R.string.achter_gelegt4,R.string.achter_gelegt5,R.string.achter_gelegt6,R.string.achter_gelegt6};


    public static Achterknoteng newInstance(int section_number) {
        Achterknoteng fragment = new Achterknoteng();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }
    public Achterknoteng() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_achterknoten, container, false);
        wButton = (Button) rootView.findViewById(R.id.achtergw);
        wButton.setOnClickListener(this);
        zButton = (Button) rootView.findViewById(R.id.achtergz);
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
        if (view.getId() == R.id.achtergw) achtergweiter(getView());
        if (view.getId() == R.id.achtergz) achtergzurueck(getView());
    }


    public void achtergweiter(View view)
    {

        ImageView img = (ImageView) getView().findViewById(R.id.achtergimg);
        img.setImageResource(imgsrc[index]);
        Button butw = (Button) getView().findViewById(R.id.achtergw);
        Button butz = (Button) getView().findViewById(R.id.achtergz);

        TextView tex = (TextView) getView().findViewById(R.id.achtergtxt);
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

    public void achtergzurueck(View view)
    {
        index = index - 1;
        ImageView img = (ImageView) getView().findViewById(R.id.achtergimg);
        TextView tex = (TextView) getView().findViewById(R.id.achtergtxt);
        Button butw = (Button) getView().findViewById(R.id.achtergw);
        Button butz = (Button) getView().findViewById(R.id.achtergz);

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

