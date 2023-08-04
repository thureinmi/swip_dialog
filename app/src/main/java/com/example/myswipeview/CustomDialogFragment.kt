import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myswipeview.MyItem
import com.example.myswipeview.R

class CustomDialogFragment : DialogFragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter
    private var currentItemPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the ViewPager2 in the dialog layout
        viewPager = view.findViewById(R.id.viewPager)

        // Replace 'yourItemList' with the actual list of items you want to display in ViewPager2
        val itemList = listOf(
            MyItem("This is item 1"),
            MyItem("This is item 2"),
            MyItem("This is item 3")
        )

        adapter = ViewPagerAdapter(itemList)
        viewPager.adapter = adapter

        val previousButton: Button = view.findViewById(R.id.previousButton)
        previousButton.setOnClickListener { showPreviousItem() }

        val nextButton: Button = view.findViewById(R.id.nextButton)
        nextButton.setOnClickListener { showNextItem() }
    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        return dialog
    }

    private fun showNextItem() {
        if (currentItemPosition < adapter.itemCount - 1) {
            currentItemPosition++
            viewPager.setCurrentItem(currentItemPosition, true)
        }
    }

    private fun showPreviousItem() {
        if (currentItemPosition > 0) {
            currentItemPosition--
            viewPager.setCurrentItem(currentItemPosition, true)
        }
    }
}
