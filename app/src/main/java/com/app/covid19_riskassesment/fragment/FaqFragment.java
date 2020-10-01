package com.app.covid19_riskassesment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.covid19_riskassesment.R;
import com.app.covid19_riskassesment.adapter.FaqAdapter;
import com.app.covid19_riskassesment.model.FaqModel;

import java.util.ArrayList;

public class FaqFragment extends Fragment {

    //const

    //var
    private ArrayList<FaqModel> faqs;

    //widgets
    private LinearLayout rootView;
    private RecyclerView faq_RV;


    public FaqFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        faqs = new ArrayList<>();

        faqs.add(new FaqModel("What precautions should I take when I go out?",
                "Make sure you have no cough or cold (not coughing/sneezing of any type)? \n" +
                        "\n" +
                        "i)\tFirst ascertain whether you really need to take the risk of going out of the house?\n" +
                        "ii)\tIf yes, then carry your ID, rehearse the VALID REASON in your mind, set a time frame to accomplish the purpose without having to prolong the stay outside home safety.\n" +
                        "iii)\tPhysical Distancing(Never getting within 1 metre of any person)\n" +
                        "iv)\tWear a mask (covering nose and mouth) or ensure physical distancing.\n" +
                        "v)\tAfter coming home wash hands for 20-30 seconds and sanitize.\n" +
                        "(Respiratory Hygiene to be practiced at home (Sneezing or coughing in the elbow or using tissue that is to be instantly trashed followed by hand washing)\n" +
                        "vi)\tPhysical distancing after coming back home too, as far as possible.\n"));
        faqs.add(new FaqModel("How do I take care of my mental health when under ISOLATION or QUARANTINE?",
                "a)\tMaintenance of Mental Hygiene: Disinfection of UNWANTED OBSESSIVE NEGATIVE THOUGHTS\n" +
                        "b)\tMaintaining Mental Discipline by reducing STRESS , ANXIETY and MORBID FEAR by:\n" +
                        "i)\tLearning to RATIONALIZE BAD THOUGHTS\n" +
                        "ii)\tDoing THE BEST at ‘what is in control’\n" +
                        "iii)\tTrying to learn to forget ‘what is BEYOND CONTROL’\n" +
                        "iv)\tExercising, Eating well, Keeping hydrated, Sleeping well\n" +
                        "v)\tNot resorting to or succumbing to forgotten vices such as smoking, alcohol and the likes.\n" +
                        "\n" +
                        "ISOLATION: \n" +
                        "i)\tPurpose is to protect your immediate family members; this has to sink in, although it is initially tough to accept.\n" +
                        "ii)\tMore than 80% of those who are positive will have no symptoms or very mild symptoms.\n" +
                        "iii)\t15% will have some severity and there is a need for someone to attend and monitor to prevent more severe symptoms(Moderate to Severe) \n" +
                        "iv)\t5% of those with some other underlying medical condition may need support for breathing(Critical)\n" +
                        "v)\tDo what you loved to do ‘when you preferred to be alone’ even in normal situations in your life.\n" +
                        "vi)\tContemplation, meditation, pleasant memories, revisiting old hobbies, rediscovering creativity, autobiography etc.\n" +
                        "\n" +
                        "QUARANTINE:\n" +
                        "i)\tPurpose is again to protect your close family members\n" +
                        "ii)\tHome Quarantine in a separate room to be alone to be strictly followed if risk is found in assessment as discussed under Question2.\n" +
                        "iii)\tGo back to your hobbies or activities that till now were ‘left on the shelf’ for various reasons including ‘lack of time’!\n"));
        faqs.add(new FaqModel("What should I do if I think I’ve got Covid-19?",
                "i)\tAnswer the Questions 1 and 2 again.\n" +
                        "ii)\tIf you still feel you have Covid-19, be honest to yourself about the precautions you’ve taken under Question 3?\n" +
                        "iii)\tIf you still have apprehensions, go through the points under Question 4\n" +
                        "iv)\tEven now if you have some fear, analyze if it is related to misinformation(News/Social Media/Parental Concern etc)\n" +
                        "v)\tIf something is driven by COMMON SENSE KNOWLEDGE, it’s better to get TESTED. Convince yourself!\n"));
        faqs.add(new FaqModel("What should I do if I think someone in my family has Covid-19?",
                "i)\tAnswer Question 2 or get the family member answer the same to be absolutely certain.\n" +
                        "ii)\tIf you still feel your family member has Covid-19, ask him to be honest to himself about the precautions you’ve taken under Question 3?\n" +
                        "iii)\tIf your family member still has apprehensions, ask him/her to go through the points under Question 4\n" +
                        "iv)\tEven now if he/her some fear, analyze if it is related to misinformation(News/Social Media/Parental Concern etc)\n" +
                        "v)\tIf something is driven by his/her COMMON SENSE KNOWLEDGE, it’s better to get TESTED. Convince him/her to do so.\n"));
        faqs.add(new FaqModel("How does Covid-19 spread?",
                "i)\tCorona Virus is found in the droplets that are ejected from a person when he coughs or sneezes or speaks, that can be carried up to 1 metre under normal circumstances or may even be up to 2 metres depending upon the FORCE EXERTED while coughing or sneezing or speaking/talking/shouting……!\n" +
                        "ii)\tVirus is not airborne (in the air) unless there is a violent mechanism that disturbs the virus found viable on some surface that is contaminated (Fomites such as furniture, door-knobs, switches, Elevator buttons etc.)\n" +
                        "iii)\tVirus may be airborne (in the air) where procedures that involve intubation/Ventilator use etc. This is a potential risk for only the Health Personnel in ISOLATION WARDS. \n" +
                        "iv)\tViruses found on surfaces may get on to our hands and if we touch our eyes or nose of lips, consciously or subconsciously, it enters the body and thereafter, multiplies resulting in INFECTION that could even lead to Covid-19 (that could vary from very mild to very severe symptoms)\n" +
                        "Hence the HEALTH ADVISORY in all possible PROPAGANDA MEDIA regarding REPIRATORY HYGIENE, HAND HYGIENE, COUGH ETIQUETTE, DISINFECTION OF SURFACES, APPROPRIATE USE OF MASKS, PHYSICAL DISTANCING, SOCIAL DISTANCING.\n"));
        faqs.add(new FaqModel("What are the BEST PRACTICES for PREVENTING COVID-19 by the PEOPLE IN THE COMMUNITY?",
                "i)\tRead again to reinforce consciously the mode of transmission of the virus in all Public Places where there is more than ONE PERSON!\n" +
                        "ii)\tTwo is no longer COMPANY; ‘TWO IS NOW CROWD IN PUBLIC PLACES!’  \n" +
                        "iii)\tBEST  PREVENTIVE PRACTICES in the order of priority:-\n" +
                        "a)\tNO CROWDING( Read ii given under Question 7)\n" +
                        "b)\tSocial Distancing to protect family members while staying socially connected.\n" +
                        "c)\tPhysical Distancing not less than one metre\n" +
                        "d)\tRespiratory Hygiene\n" +
                        "e)\tHand Hygiene\n" +
                        "f)\tCough Etiquette\n" +
                        "g)\tDisinfection of commonly shared surfaces/fomites\n" +
                        "h)\tAppropriate/Scientific use of MASKS*\n" +
                        "*Just using masks without practicing the other higher order protective measures (a to g given above) poses a serious threat of spreading not only Corona, but even other influenza viruses and bacteria (including Tuberculosis)\n" +
                        "*Use of MASK is to protect others from droplets, not to protect yourself from Corona.\n" +
                        "*Combination of all best practices given above is MOST SENSIBLE as well as MOST PROTECTIVE.\n"));
        faqs.add(new FaqModel("Why shouldn’t I pray in Groups or attend religious gatherings without taking all precautions and preventive measures? ",
                "i)\tUnderstand and appreciate the answer to Question 7 to educate everyone in the family regarding mode of spread of the virus.\n" +
                        "ii)\tExplain the answers under Question 7 to everyone beyond just your own family.\n" +
                        "iii)\tExplain the danger of risk of contracting the virus when the physical distance between two people is less than ONE METRE.(Answer to Question 7)\n" +
                        "iv)\tHousehold transmission and also in closed settings was found to be high in China.\n" +
                        "v)\tExplain the same logic to all RELIGIOUS LEADERS, YOUTH, Islamic groups, Churches, Temples, Ashrams or any form of gatherings.\n"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faq, container, false);

        rootView = view.findViewById(R.id.faqRootView_LL);
        faq_RV = view.findViewById(R.id.faq_RV);

        initializeRecyclerView();

        return view;
    }

    private void initializeRecyclerView() {

        faq_RV.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        faq_RV.setAdapter(new FaqAdapter(getActivity(), faqs, rootView));

    }
}