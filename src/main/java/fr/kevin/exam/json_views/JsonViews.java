package fr.kevin.exam.json_views;

public class JsonViews {

    public interface RegionMinimalView { }
    public interface RegionListView extends
            RegionMinimalView { }
    public interface RegionShowView extends
            RegionMinimalView { }

    public interface DepartmentListView { }

    public interface DepartmentShowView extends
            DepartmentListView,
            RegionListView { }

}
