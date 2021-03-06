package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroupDeletionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() ==0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }


  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    app.goTo().groupPage();
    assertThat(app.group().count(), equalTo(before.size()-1));
    Groups after = app.group().all();
    before.remove(deletedGroup);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
