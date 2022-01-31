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
 * {@link Doppelschlingeg.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Halbschlag#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Doppelschlingeg extends Fragment implements Button.OnClickListener{

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button wButton;
    private Button zButton;

    int index = 1;
    int[] imgsrc = {R.drawable.doppelsclinge_gelegt1,R.drawable.doppelsclinge_gelegt2,R.drawable.doppelsclinge_gelegt3,R.drawable.doppelsclinge_gelegt3};
    int[] texsrc = {R.string.doppel_gelegt1,R.string.doppel_gelegt2,R.string.doppel_gelegt3,R.string.doppel_gelegt3};

    public static Doppelschlingeg newInstance(int section_number) {
        Doppelschlingeg fragment = new Doppelschlingeg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }
    public Doppelschlingeg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_doppelschlinge, container, false);
        wButton = (Button) rootView.findViewById(R.id.dopelgw);
        wButton.setOnClickListener(this);
        zButton = (Button) rootView.findViewById(R.id.doppelgz);
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
        if (view.getId() == R.id.achtergw) weiter(getView());
        if (view.getId() == R.id.achtergz) zurueck(getView());
    }

    public void weiter(View view)
    {

        ImageView img = (ImageView) getView().findViewById(R.id.doppelgimg);
        img.setImageResource(imgsrc[index]);
        Button butw = (Button) getView().findViewById(R.id.dopelgw);
        Button butz = (Button) getView().findViewById(R.id.doppelgz);

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

    public void zurueck(View view)
    {
        index = index - 1;
        ImageView img = (ImageView) getView().findViewById(R.id.doppelgimg);
        TextView tex = (TextView) getView().findViewById(R.id.doppelgtxt);
        Button butw = (Button) getView().findViewById(R.id.dopelgw);
        Button butz = (Button) getView().findViewById(R.id.doppelgz);

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
