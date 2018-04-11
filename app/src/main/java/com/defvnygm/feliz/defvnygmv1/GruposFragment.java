package com.defvnygm.feliz.defvnygmv1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GruposFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GruposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GruposFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerGrupos;
    ArrayList<GrupoVo> listaGrupos;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public GruposFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GruposFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GruposFragment newInstance(String param1, String param2) {
        GruposFragment fragment = new GruposFragment();
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
        View vista = inflater.inflate(R.layout.fragment_grupos, container, false);

        listaGrupos = new ArrayList<>();
        recyclerGrupos = vista.findViewById(R.id.recyclerId);
        recyclerGrupos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        GruposAdapter adapter = new GruposAdapter(listaGrupos);
        recyclerGrupos.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Selecciono: "+listaGrupos.get(recyclerGrupos.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarGrupo(listaGrupos.get(recyclerGrupos.getChildAdapterPosition(view)));
            }
        });

        return vista;
    }

    private void llenarLista() {
        listaGrupos.add(new GrupoVo(getString(R.string.grupo1_nombre),getString(R.string.grupo1_desc_corta),getString(R.string.grupo1_desc_larga),R.drawable.foto1,R.drawable.f1));
        listaGrupos.add(new GrupoVo(getString(R.string.grupo2_nombre),getString(R.string.grupo2_desc_corta),getString(R.string.grupo2_desc_larga),R.drawable.foto2,R.drawable.f2));
        listaGrupos.add(new GrupoVo(getString(R.string.grupo3_nombre),getString(R.string.grupo3_desc_corta),getString(R.string.grupo3_desc_larga),R.drawable.foto3,R.drawable.f3));
        listaGrupos.add(new GrupoVo(getString(R.string.grupo4_nombre),getString(R.string.grupo4_desc_corta),getString(R.string.grupo4_desc_larga),R.drawable.foto4,R.drawable.f4));
        listaGrupos.add(new GrupoVo(getString(R.string.grupo5_nombre),getString(R.string.grupo5_desc_corta),getString(R.string.grupo5_desc_larga),R.drawable.foto5,R.drawable.f5));
        listaGrupos.add(new GrupoVo(getString(R.string.grupo6_nombre),getString(R.string.grupo6_desc_corta),getString(R.string.grupo6_desc_larga),R.drawable.foto6,R.drawable.f6));
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

        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;
        }
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

    public FragmentManager getSupportFragmentManager() {
        return null;
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
