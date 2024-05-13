package com.example.virginmoneyhilt.ui.person_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneyhilt.R

import com.example.virginmoneyhilt.databinding.FragmentPersonListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PersonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonListFragment : Fragment() {

    private lateinit var binding: FragmentPersonListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //1st initialize the binding
        binding = FragmentPersonListBinding.inflate(inflater, container, false)

        //2nd create reference for view model
        val peopleListViewModel = ViewModelProvider(this)[PersonListViewModel::class.java]

        //3rd create root val to hold binding.root
        val root = binding.root

        //4th use binding to set onclick listner to navigate to desired Fragment
        binding.apply {
//            binding.apply {
//            tvPersonListText.setOnClickListener {
//                //navigate to person details fragment
//                findNavController().navigate(R.id.personDetailsFragment)
//            }

                //5th use the view model to populate the data/live data into the current fragment
                //live data is data that we are pulling from backend
                peopleListViewModel.personList.observe(viewLifecycleOwner) {
//                tvPersonListText.text = it

                    //6th RecyclerView needs two things Layout Manager and Adapter
                    binding.rvPeople.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = PeopleListAdapter(it) { peopleItemModel ->
                            findNavController().navigate(
                                R.id.action_nav_people_list_to_personDetailsFragment, //<-- Code to be checked. When replace with R.id.personDetailsFragment it doesn't crash the app
                                bundleOf(
                                    Pair("id", peopleItemModel.id),
                                    Pair("firstname", peopleItemModel.firstName),
                                    Pair("lastname", peopleItemModel.lastName),
                                    Pair("email", peopleItemModel.email),
                                    Pair("jobtitle", peopleItemModel.jobtitle),
                                    Pair("favouriteColor", peopleItemModel.favouriteColor),
                                    Pair("avatar", peopleItemModel.avatar)

                                )
                            )

                        }
                    }

                }
            }
            // Inflate the layout for this fragment
            return root
        }
    }
//}