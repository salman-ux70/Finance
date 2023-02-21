package com.zat.finance.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.zat.finance.utils.viewModels.ViewModelFactory
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.temporal.WeekFields
import java.util.*


const val USER_ID = "USER_ID"
const val PRODUCT_ID = "PRODUCT_ID"
const val USER = "USER"
const val LEADER = "LEADER"
const val ROLE = "ROLE"
const val FEED_ID = "FEED_ID"
const val CATEGORY_NAME = "CATEGORY_NAME"
const val FRAGMENT_NAME = "FRAGMENT_NAME"
const val SOMETHING_WENT_WRONG = "Something went wrong"
const val IMAGE_BASE_URL = "https://aaiyp.zat.agency/public/"

fun EditText.getString() = this.text.toString()
fun EditText.isEmpty() = this.text.toString() == ""

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelFactory.getInstance(requireActivity().application!!)
        .create(viewModelClass)
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE

}


fun dpFromPx(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}

fun pxFromDp(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}

suspend fun prepareFilePart(
    partName: String,
    path: String,
    fileType: Int
): MultipartBody.Part? {

    try {
        val file = File(path)
//            if (!dirFile.exists()) {
//                dirFile.mkdir();
//            }
//            var compressedFile = File(dirFile, "compressed_${file.name}")
//
//
//            var compressedImageFile = Compressor.compress(getApplication(), file) {
//                default()
//                destination(compressedFile)
//
//
//            }
        var requestFile: RequestBody? = null
        when (fileType) {
            0 -> {
                requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
            }
            1 -> {
                requestFile = file.asRequestBody("video/*".toMediaTypeOrNull())
            }
            2 -> {
                requestFile = file.asRequestBody("*/*".toMediaTypeOrNull())
            }
        }
        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.name, requestFile!!)
    } catch (e: Exception) {
        return null
    }

}


fun EditText.disable() {
    this.isClickable = true
    this.isFocusable = false
    this.inputType = InputType.TYPE_NULL
}


fun TextView.setTextColorRes(@ColorRes color: Int) =
    setTextColor(ContextCompat.getColor(context, color))


fun Activity.showDateDialog(selectedDate: (String) -> Unit) {
    var calStart = Calendar.getInstance()
    val dateSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calStart.set(Calendar.YEAR, year)
            calStart.set(Calendar.MONTH, monthOfYear)
            calStart.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "yyyy-MM-dd"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            selectedDate(sdf.format(calStart.time))

        }

    val datePickerDialog = DatePickerDialog(
        this,
        dateSetListener,
        calStart.get(Calendar.YEAR),
        calStart.get(Calendar.MONTH),
        calStart.get(Calendar.DAY_OF_MONTH),
    )

    datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
    datePickerDialog.show()
}

fun Activity.showTimeDialog(selectedTime: (String) -> Unit) {
    val cal = Calendar.getInstance()
    val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, minute)
        selectedTime(SimpleDateFormat("HH:mm").format(cal.time))

    }
    TimePickerDialog(
        this,
        timeSetListener,
        cal.get(Calendar.HOUR_OF_DAY),
        cal.get(Calendar.MINUTE),
        true
    ).show()
}


fun Dialog.setDialogStyle() {
    this.window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
    this.window?.setBackgroundDrawableResource(android.R.color.transparent)
    this.setCancelable(true)
}


//fun getPopupDialog(context: Context, layoutId: Int) = object: Dialog(context, R.style.Custom_Dialog){
//    init {
//        setDialogStyle()
//        setContentView(layoutId)
//    }
//}

//fun showAlert(
//    context: Context,
//    title: String,
//    message: String,
//    isCancelVisible: Boolean,
//    okClick: () -> Unit
//) {
//    var dialog = getPopupDialog(context, R.layout.popup_confirmation)
//
//    dialog.titleTxt.text = title
//    dialog.messageTxt.text = message
//
//    dialog.okBtn.singleClick {
//        dialog.dismiss()
//        okClick()
//    }
//
//    if (isCancelVisible) {
//        dialog.cancelBtn.visible()
//    } else {
//        dialog.cancelBtn.gone()
//    }
//
//    dialog.cancelBtn.singleClick {
//        dialog.dismiss()
//    }
//
//    dialog.show()
//}

fun View.singleClick(onClick: () -> Unit) {
    this.setOnClickListener(object : OnSingleClickListener() {
        override fun onSingleClick(v: View?) {
            onClick()
        }

    })
}

@RequiresApi(Build.VERSION_CODES.O)
fun daysOfWeekFromLocale(): Array<DayOfWeek> {
    val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
    var daysOfWeek = DayOfWeek.values()
    // Order `daysOfWeek` array so that firstDayOfWeek is at index 0.
    if (firstDayOfWeek != DayOfWeek.MONDAY) {
        val rhs = daysOfWeek.sliceArray(firstDayOfWeek.ordinal..daysOfWeek.indices.last)
        val lhs = daysOfWeek.sliceArray(0 until firstDayOfWeek.ordinal)
        daysOfWeek = rhs + lhs
    }
    return daysOfWeek
}


fun convertTime(time: String): String? {
    val formatter = SimpleDateFormat("h:mm a")
    return formatter.format(Date(time.toLong()))
}


fun loadImage(context: Context, url: String, imageView: ImageView, placeholder: Int) {

    Glide.with(context)
        .load(url)
        .apply(RequestOptions.skipMemoryCacheOf(true))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(placeholder)
        .into(imageView).onLoadFailed(context.getDrawable(placeholder));

}

fun getPath(context: Context, uri: Uri): String {

    var path: String? = null
    var projection: Array<String> = arrayOf(MediaStore.Files.FileColumns.DATA)
    var cursor = context.contentResolver.query(uri, projection, null, null, null)

    if (cursor == null) {
        path = uri.getPath()
    } else {
        cursor.moveToFirst();
        var column_index = cursor.getColumnIndexOrThrow(projection[0]);
        path = cursor.getString(column_index);
        cursor.close();
    }

    return if (path == null || path.isEmpty()) {
        uri.path.toString()
    } else {
        path
    }
}

@SuppressLint("SimpleDateFormat")
fun getNormalDateInText(timeInMillies: Long): String? {
    var date: String? = null
    val formatter = SimpleDateFormat("dd-MMM")
    date = formatter.format(timeInMillies)
    return date
}

var dummyList = object : ArrayList<String>() {
    init {
        add("Wi-fi Network")
        add("Storage Room Access")
        add("Trash & Recycle")
        add("Check out info")
        add("Wi-fi Network")
        add("Storage Room Access")
        add("Trash & Recycle")
        add("Check out info")
        add("Wi-fi Network")


    }
}


var bookingList = object : ArrayList<String>() {
    init {
        add("Add Transport")
        add("Number Plate")
        add("Vehicle Registration")
    }
}
var documentsList = object : ArrayList<String>() {
    init {
        add("Driving Licience")
        add("ID Card Information")
        add("CNIC")
    }
}