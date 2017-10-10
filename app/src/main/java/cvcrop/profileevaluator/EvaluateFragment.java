package cvcrop.profileevaluator;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EvaluateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EvaluateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvaluateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EvaluateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EvaluateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EvaluateFragment newInstance(String param1, String param2) {
        EvaluateFragment fragment = new EvaluateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_evaluate, container, false);



        // Handle Next button

        Button button = (Button) view.findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EvaluateFragment2 evaluateFragment2=EvaluateFragment2.newInstance("","");
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,evaluateFragment2,evaluateFragment2.getTag()).commit();
            }
        });


        // Setting Current Degree spinner
        AutoCompleteTextView degreeAText = (AutoCompleteTextView) view.findViewById(R.id.current_degree_atext);

        ArrayAdapter<CharSequence> adapterCurrentDegree = ArrayAdapter.createFromResource(getActivity(),
                R.array.current_degree, android.R.layout.select_dialog_item);



        degreeAText.setAdapter(adapterCurrentDegree);
        degreeAText.setTextColor(Color.BLACK);
        degreeAText.setTextSize(12);

         // Setting Current Major spinner

        AutoCompleteTextView majorAText = (AutoCompleteTextView) view.findViewById(R.id.current_major_atext);

        ArrayAdapter<CharSequence> adapterCurrentMajor = ArrayAdapter.createFromResource(getActivity(),
                R.array.current_major, android.R.layout.select_dialog_item);



        majorAText.setAdapter(adapterCurrentMajor);

        // Setting Colleges spinner

        AutoCompleteTextView collegesAText = (AutoCompleteTextView) view.findViewById(R.id.colleges_atext);

        ArrayAdapter<CharSequence> adapterColleges= ArrayAdapter.createFromResource(getActivity(),
                R.array.colleges, android.R.layout.select_dialog_item);



        collegesAText.setAdapter(adapterColleges);

        Integer currentYear=Calendar.getInstance().get(Calendar.YEAR);
        String[] years={currentYear.toString(),(currentYear-1)+"",(currentYear-2)+"",(currentYear-3)+"",(currentYear-4)+"",
                (currentYear-5)+"",(currentYear-6)+"",(currentYear-7)+"",(currentYear-8)+"",(currentYear-9)+"",(currentYear-10)+""};
        Spinner yopSpinner=(Spinner)view.findViewById(R.id.yop_spinner);
        ArrayAdapter<String> adapterYop=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,years);
        yopSpinner.setAdapter(adapterYop);


        AutoCompleteTextView domainsText=(AutoCompleteTextView) view.findViewById(R.id.domain);
        ArrayAdapter<CharSequence> adapterDomains=ArrayAdapter.createFromResource(getActivity(),R.array.domains,android.R.layout.select_dialog_item);
        domainsText.setAdapter(adapterDomains);

        return view;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
