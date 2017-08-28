package com.github.ppadial.testrail.client.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.ppadial.testrail.client.apiClient.ApiClient;
import com.github.ppadial.testrail.client.model.TRProject;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectApiIT {

  private ApiClient apiClient;
  private ProjectServiceClient projectServiceClient;

  final String name = "Testrail Client IT";
  final String updatedName = "Testrail Client IT Updated";

  @BeforeMethod
  public void setUp() throws Exception {
    apiClient = new ApiClient("", "", "");
    projectServiceClient = new ProjectServiceClient(apiClient);

    // Verify Our Demo doesn't exists
    final List<TRProject> projects = projectServiceClient.getProjects();
    projects.stream().filter(x -> StringUtils.equalsIgnoreCase(x.name, name) || StringUtils.equalsIgnoreCase(x.name, updatedName)
    ).forEach( (x) -> {
      try {
        projectServiceClient.deleteProject(x.id);
      } catch (Exception exception) {
        ;
      }
    });
  }

  @Test
  public void testCrudForProject() throws Exception {
    // A.
    final TRProject trProject;
    final TRProject getProject;
    final TRProject updatedProject;
    final String announcement = "announcement";
    final String updatedAnnouncement = "announcement updated";
    final List<TRProject> projects;

    // 1. Create Project
    trProject = projectServiceClient
        .addProject(name, announcement, false, SuiteMode.SINGLE);

    // . Verify Created Project
    assertThat(trProject).isNotNull();
    assertThat(trProject.name).isEqualTo(name);
    getProject = projectServiceClient.getProject(trProject.id);
    assertThat(getProject).isNotNull();
    assertThat(getProject.name).isEqualTo(trProject.name);
    assertThat(getProject.announcement).isEqualTo(trProject.announcement);
    assertThat(getProject.showAnnouncement).isEqualTo(trProject.showAnnouncement);
    assertThat(getProject.isCompleted).isEqualTo(trProject.showAnnouncement);

    // 2. Update project
    updatedProject =
        projectServiceClient
            .updateProject(getProject.id, updatedName, updatedAnnouncement, true, null,
                true);

    // . Verify updated project
    assertThat(updatedProject).isNotNull();
    assertThat(updatedProject.name).isEqualTo(updatedName);
    assertThat(updatedProject.announcement).isEqualTo(updatedAnnouncement);
    assertThat(updatedProject.isCompleted).isEqualTo(true);
    assertThat(updatedProject.showAnnouncement).isEqualTo(true);
    assertThat(updatedProject.suiteMode).isEqualTo(SuiteMode.SINGLE.getValue());

    // 3. Delete Project
    projectServiceClient.deleteProject(updatedProject.id);

    // . Verify project doesn't exists
    projects = projectServiceClient.getProjects();
    assertThat(projects).doesNotContain(updatedProject);
  }
}