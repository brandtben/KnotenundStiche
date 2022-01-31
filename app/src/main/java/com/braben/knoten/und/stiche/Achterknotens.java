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
public class Achterknotens extends Fragment implements Button.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button wButton;
    private Button zButton;

    int index = 1;
    int[] imgsrc = {R.drawable.achter_gestochen1,R.drawable.achter_gestochen2,R.drawable.achter_gestochen3,R.drawable.achter_gestochen4,R.drawable.achter_gestochen5,R.drawable.achter_gestochen6,R.drawable.achter_gestochen7,R.drawable.achter_gestochen8,R.drawable.achter_gestochen9,R.drawable.achter_gestochen10,R.drawable.achter_gestochen11,R.drawable.achter_gestochen11};
    int[] texsrc = {R.string.achter_gestochen1,R.string.achter_gestochen2,R.string.achter_gestochen3,R.string.achter_gestochen4,R.string.achter_gestochen5,R.string.achter_gestochen6,R.string.achter_gestochen7,R.string.achter_gestochen8,R.string.achter_gestochen9,R.string.achter_gestochen10,R.string.achter_gestochen11,R.string.achter_gestochen11};


    public static Achterknotens newInstance(int section_number) {
        Achterknotens fragment = new Achterknotens();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }
    public Achterknotens() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_achterknotens, container, false);
        wButton = (Button) rootView.findViewById(R.id.achtersw);
        wButton.setOnClickListener(this);
        zButton = (Button) rootView.findViewById(R.id.achtersz);
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
        if (view.getId() == R.id.achtersw) achtersweiter(getView());
        if (view.getId() == R.id.achtersz) achterszurueck(getView());
    }


    public void achtersweiter(View view)
    {

        ImageView img = (ImageView) getView().findViewById(R.id.achtersimg);
        img.setImageResource(imgsrc[index]);
        Button butw = (Button) getView().findViewById(R.id.achtersw);
        Button butz = (Button) getView().findViewById(R.id.achtersz);

        TextView tex = (TextView) getView().findViewById(R.id.achterstxt);
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

    public void achterszurueck(View view)
    {
        index = index - 1;
        ImageView img = (ImageView) getView().findViewById(R.id.achtersimg);
        TextView tex = (TextView) getView().findViewById(R.id.achterstxt);
        Button butw = (Button) getView().findViewById(R.id.achtersw);
        Button butz = (Button) getView().findViewById(R.id.achtersz);

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

