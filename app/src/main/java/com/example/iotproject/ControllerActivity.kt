package com.example.iotproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.iotproject.databinding.ActivityControllerBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ControllerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityControllerBinding
    private var clicked = false
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    // Create separate DatabaseReference for each button
    private val deviceReference: DatabaseReference = database.getReference("device")
    private val lightsReference: DatabaseReference = database.getReference("lights")
    private val waterPumpReference: DatabaseReference = database.getReference("waterPump")
    private val sprinkleReference: DatabaseReference = database.getReference("sprinkle")
    private val exhaustFansReference: DatabaseReference = database.getReference("exhaustFans")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControllerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListener for all buttons.
        binding.btnDevice.setOnClickListener {
            Checker(binding.btnDevice, deviceReference)
        }
        binding.btnLights.setOnClickListener {
            Checker(binding.btnLights, lightsReference)
        }
        binding.btnWaterPump.setOnClickListener {
            Checker(binding.btnWaterPump, waterPumpReference)
        }
        binding.btnSprinkle.setOnClickListener {
            Checker(binding.btnSprinkle, sprinkleReference)
        }
        binding.btnExhaustFans.setOnClickListener {
            Checker(binding.btnExhaustFans, exhaustFansReference)
        }
    }

    // Button text changer ON or OFF function.
    private fun Checker(button: Button, reference: DatabaseReference) {
        if (clicked) {
            button.text = "OFF"
            clicked = false
        } else {
            button.text = "ON"
            clicked = true
        }
        // Save the Boolean value to the specific DatabaseReference
        val valueToSave = clicked // The Boolean value
        reference.setValue(valueToSave)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Set all database values to false before the activity is destroyed
        deviceReference.setValue(false)
        lightsReference.setValue(false)
        waterPumpReference.setValue(false)
        sprinkleReference.setValue(false)
        exhaustFansReference.setValue(false)
    }
}
