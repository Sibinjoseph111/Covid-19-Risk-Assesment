package com.app.covid19_riskassesment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.covid19_riskassesment.R;

public class GuidelinesFragment extends Fragment {

    //var
    private String guidelines = "The virus that was found in people that had gone under ‘house-arrest’ during lockdown with countries reopening to " +
            "economy, so has the potential of the virus to go astray on the streets, and spread in the community.\n\n" +
            "More so in ‘Closed Spaces’ with poor ventilation where physical distancing is not possible; ‘Close Contacts’ in public places and ‘Crowded Dwellings’. " +
            "Under these circumstances failure to ensure distancing willingly or unwillingly compromise on complementing all recommended measures of prevention such as:-\n\n" +
            "1)\tHand hygiene/sanitization\n" +
            "2)\tDisinfection of shared surfaces\n" +
            "3)\tCough and Sneeze Etiquette(Elbow or tissue)\n" +
            "4)\tRespiratory Hygiene( Mouth wash/salt water gargling etc)\n" +
            "5)\tCovering Nose and Mouth appropriately with covering/Mask\n" +
            "6)\tMask Hygiene-Changing as and when required based on guidelines recommending use of mask effectively.\n" +
            "7)\tSafe disposal of used Masks and other PPE failing which there could be hazardous risks to anyone coming in the vicinity of such places.\n" +
            "8)\tAvoid touching eyes, nose or mouth as the virus might get inoculated and result in potential viral infection  \n" +
            "\n" +
            "The best option to stay at home.The risk of coming out of the house means that either you are carrying the virus ‘waiting to transmit’ to someone who comes in close " +
            "contact, or you are offering yourself the risk of contracting the virus from someone.\n" +
            "If someone has to step out, the family ought to nominate a person to venture out with all precautions to keep the virus at bay!\n\n" +
            "Whatever has happened till now has happened. Nothing can be re-written. Now since the lockdown and the gradual relaxations to get the economy back on track, every " +
            "household needs to reassess every individual’s risk of having already contracted the virus!\n";

    //widgets
    private TextView guidelines_TV;

    public GuidelinesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guidelines, container, false);

        guidelines_TV = view.findViewById(R.id.guidelines_TV);

        guidelines_TV.setText(guidelines);

        return view;
    }
}