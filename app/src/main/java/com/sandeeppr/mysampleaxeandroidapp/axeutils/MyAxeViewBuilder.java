package com.sandeeppr.mysampleaxeandroidapp.axeutils;

import com.deque.axe.android.AxeView;
import com.deque.axe.android.wrappers.AxeRect;

import java.util.ArrayList;
import java.util.List;

public class MyAxeViewBuilder implements AxeView.Builder {
    private List<AxeView.Builder> children = new ArrayList<>();

    private AxeRect boundsInScreen = new AxeRect(0, 0, 0, 0);

    private String className = Object.class.getSimpleName();

    private String contentDescription = null;

    private boolean isAccessibilityFocusable = false;

    private boolean isClickable = false;

    private boolean isEnabled = true;

    private boolean isImportantForAccessibility = false;

    private AxeView labeledBy = null;

    private String paneTitle = null;

    private String text = null;

    private String hintText = null;

    private String value = null;

    private String viewIdResourceName = "";

    public MyAxeViewBuilder() { }

    private MyAxeViewBuilder(MyAxeViewBuilder deepCopyThis) {
        children = deepCopyThis.children;
        boundsInScreen = deepCopyThis.boundsInScreen;
        className = deepCopyThis.className;
        contentDescription = deepCopyThis.contentDescription;
        isAccessibilityFocusable = deepCopyThis.isAccessibilityFocusable;
        isClickable = deepCopyThis.isClickable;
        isEnabled = deepCopyThis.isEnabled;
        isImportantForAccessibility = deepCopyThis.isImportantForAccessibility;
        labeledBy = deepCopyThis.labeledBy;
        viewIdResourceName = deepCopyThis.viewIdResourceName;
        text = deepCopyThis.text;
        hintText = deepCopyThis.hintText;
        value = deepCopyThis.value;
        paneTitle = deepCopyThis.paneTitle;
    }

    /**
     * Add a child builder to this hierarchy. This child is deep copied,
     * so the same builder can be used to create another child. In fact,
     * you could continually reference the same builder, but that would
     * be hard to do correctly. Don't do this.
     * @param child The child builder to add.
     */
    public void addChild(MyAxeViewBuilder child) {

        MyAxeViewBuilder copy = new MyAxeViewBuilder(child);

        children.add(copy);
    }

    public MyAxeViewBuilder boundsInScreen(final AxeRect boundsInScreen) {
        this.boundsInScreen = boundsInScreen;
        return this;
    }

    public AxeRect boundsInScreen() {
        return boundsInScreen;
    }

    public MyAxeViewBuilder className(final String newValue) {
        className = newValue;
        return this;
    }

    public String className() {
        return className;
    }

    public MyAxeViewBuilder contentDescription(final String newValue) {
        this.contentDescription = newValue;
        return this;
    }

    public String contentDescription() {
        return contentDescription;
    }

    public MyAxeViewBuilder isAccessibilityFocusable(final boolean newValue) {
        isAccessibilityFocusable = newValue;
        return this;
    }

    public boolean isAccessibilityFocusable() {
        return isAccessibilityFocusable;
    }

    public MyAxeViewBuilder isClickable(final boolean isClickable) {
        this.isClickable = isClickable;
        return this;
    }

    @Override
    public boolean isClickable() {
        return isClickable;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public MyAxeViewBuilder isEnabled(final boolean newValue) {
        isEnabled = newValue;
        return this;
    }

    @Override
    public boolean isImportantForAccessibility() {
        return isImportantForAccessibility;
    }

    public MyAxeViewBuilder isImportantForAccessibility(final boolean newValue) {
        isImportantForAccessibility = newValue;
        return this;
    }

    @Override
    public AxeView labeledBy() {
        return labeledBy;
    }

    public MyAxeViewBuilder labeledBy(AxeView labelAxeView) {
        this.labeledBy = labelAxeView;
        return this;
    }

    @Override
    public String packageName() {
        return "com.placeholder";
    }

    @Override
    public String paneTitle() {
        return paneTitle;
    }

    public MyAxeViewBuilder painTitle(final String paneTitle) {
        this.paneTitle = paneTitle;
        return this;
    }

    public MyAxeViewBuilder text(final String newValue) {
        this.text = newValue;
        return this;
    }

    public String text() {
        return text;
    }

    public MyAxeViewBuilder hintText(final String newValue) {
        this.hintText = newValue;
        return this;
    }

    public String hintText() {
        return hintText;
    }

    public String value() {
        return value;
    }

    @Override
    public String viewIdResourceName() {
        return viewIdResourceName;
    }

    public MyAxeViewBuilder viewIdResourceName(final String viewIdResourceName) {
        this.viewIdResourceName = viewIdResourceName;
        return this;
    }

    @Override
    public List<AxeView> children() {

        List<AxeView> results = new ArrayList<>();

        for (final AxeView.Builder childBuilder : children) {
            results.add(new AxeView(childBuilder));
        }
        return results;
    }

    @Override
    public boolean overridesAccessibilityDelegate() {
        return false;
    }

    public AxeView build() {
        return new AxeView(this);
    }
}
