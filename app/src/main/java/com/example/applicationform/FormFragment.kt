package com.example.applicationform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)

        val firstNameEditText: EditText = view.findViewById(R.id.firstNameEditText)
        val lastNameEditText: EditText = view.findViewById(R.id.lastNameEditText)
        val contactNumberEditText: EditText = view.findViewById(R.id.contactNumberEditText)
        val addressEditText: EditText = view.findViewById(R.id.addressEditText)
        val genderRadioGroup: RadioGroup = view.findViewById(R.id.genderRadioGroup)
        val occupationSpinner: Spinner = view.findViewById(R.id.occupationSpinner)
        val submitButton: Button = view.findViewById(R.id.submitButton)

        // Set up spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.occupation_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            occupationSpinner.adapter = adapter
        }

        // Set up button click
        submitButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val contactNumber = contactNumberEditText.text.toString()
            val address = addressEditText.text.toString()
            val occupation = occupationSpinner.selectedItem.toString()
            val selectedRadioButtonId = genderRadioGroup.checkedRadioButtonId
            val gender = if (selectedRadioButtonId == R.id.radio_male) "Male" else "Female"

            Toast.makeText(
                requireContext(),
                "Name: $firstName $lastName, Contact: $contactNumber, Address: $address, Occupation: $occupation, Gender: $gender",
                Toast.LENGTH_LONG
            ).show()
        }

        return view
    }
}
