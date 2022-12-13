package com.jt17.bottomnavtest.adapters.tests

//class SnapAdapter(
//    private val snapHelper: SnapHelper,
//    var behavior: Behaivor = Behaivor.NOTIFY_ON_SCROLL,
//    var onSnapPositionChangeListener: OnSnapPositionChangeListener? = null
//) : RecyclerView.OnScrollListener() {
//
//    enum class Behaivor {
//        NOTIFY_ON_SCROLL,
//        NOTIFY_ON_SCROLL_STATE_IDLE
//    }
//
//    private var snapPosition = RecyclerView.NO_POSITION
//
//    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//            maybeNotifySnapPositionChange(recyclerView)
//        }
//    }
//
//    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//        if (behavior == Behaivor.NOTIFY_ON_SCROLL_STATE_IDLE) {
//            maybeNotifySnapPositionChange(recyclerView)
//        }
//    }
//
//    private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
//        val snapPosition = snapHelper.getSnapPosition(recyclerView)
//        val snapPositionChanged = this.snapPosition != snapPosition
//        if (snapPositionChanged) {
//            onSnapPositionChangeListener?.onSnapPositionChange(snapPosition)
//            this.snapPosition = snapPosition
//        }
//
//
//    }
//}
//
////Listening for snap position changes
//interface OnSnapPositionChangeListener {
//    fun onSnapPositionChange(position: Int)
//}
//
////for getSnapHelper
//fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
//    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
//    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
//    return layoutManager.getPosition(snapView)
//}
//
////convenient extencion function
//fun RecyclerView.attachSnapHelperListener(
//    snapHelper: SnapHelper,
//    behavior: SnapAdapter.Behaivor = SnapAdapter.Behaivor.NOTIFY_ON_SCROLL,
//    onSnapPositionChangeListener: OnSnapPositionChangeListener
//) {
//    snapHelper.attachToRecyclerView(this)
//    val onSnapPositionChangeListener =
//        SnapAdapter(snapHelper, behavior, onSnapPositionChangeListener)
//    addOnScrollListener(onSnapPositionChangeListener)
//}